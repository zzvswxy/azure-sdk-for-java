// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.

package com.azure.containers.containerregistry.implementation;

import com.azure.containers.containerregistry.ContainerRegistryServiceVersion;
import com.azure.containers.containerregistry.implementation.authentication.ContainerRegistryCredentialsPolicy;
import com.azure.containers.containerregistry.implementation.authentication.ContainerRegistryTokenService;
import com.azure.containers.containerregistry.implementation.models.AcrErrorsException;
import com.azure.containers.containerregistry.models.ContainerRegistryAudience;
import com.azure.core.credential.TokenCredential;
import com.azure.core.exception.ClientAuthenticationException;
import com.azure.core.exception.HttpResponseException;
import com.azure.core.exception.ResourceExistsException;
import com.azure.core.exception.ResourceModifiedException;
import com.azure.core.exception.ResourceNotFoundException;
import com.azure.core.http.HttpClient;
import com.azure.core.http.HttpPipeline;
import com.azure.core.http.HttpPipelineBuilder;
import com.azure.core.http.HttpResponse;
import com.azure.core.http.policy.AddDatePolicy;
import com.azure.core.http.policy.CookiePolicy;
import com.azure.core.http.policy.HttpLogOptions;
import com.azure.core.http.policy.HttpLoggingPolicy;
import com.azure.core.http.policy.HttpPipelinePolicy;
import com.azure.core.http.policy.HttpPolicyProviders;
import com.azure.core.http.policy.RequestIdPolicy;
import com.azure.core.http.policy.RetryPolicy;
import com.azure.core.http.policy.UserAgentPolicy;
import com.azure.core.http.rest.Response;
import com.azure.core.http.rest.ResponseBase;
import com.azure.core.util.ClientOptions;
import com.azure.core.util.Configuration;
import com.azure.core.util.CoreUtils;
import com.azure.core.util.logging.ClientLogger;
import com.azure.core.util.serializer.JacksonAdapter;
import reactor.core.publisher.Mono;

import java.nio.ByteBuffer;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * This is the utility class that includes helper methods used across our clients.
 */
public final class UtilsImpl {
    private static final String CLIENT_NAME;
    private static final String CLIENT_VERSION;
    private static final int HTTP_STATUS_CODE_NOT_FOUND = 404;
    private static final int HTTP_STATUS_CODE_ACCEPTED = 202;
    public static final String OCI_MANIFEST_MEDIA_TYPE;
    public static final String DOCKER_DIGEST_HEADER_NAME;

    static {
        Map<String, String> properties = CoreUtils.getProperties("azure-containers-containerregistry.properties");
        CLIENT_NAME = properties.getOrDefault("name", "UnknownName");
        CLIENT_VERSION = properties.getOrDefault("version", "UnknownVersion");
        OCI_MANIFEST_MEDIA_TYPE = "application/vnd.oci.image.manifest.v1+json";
        DOCKER_DIGEST_HEADER_NAME = "Docker-Content-Digest";
    }

    /**
     * This method builds the httpPipeline for the builders.
     * @param clientOptions The client options
     * @param logOptions http log options.
     * @param configuration configuration settings.
     * @param retryPolicy retry policy
     * @param credential credentials.
     * @param perCallPolicies per call policies.
     * @param perRetryPolicies per retry policies.
     * @param httpClient http client
     * @param endpoint endpoint to be called
     * @param serviceVersion the service api version being targeted by the client.
     * @return returns the httpPipeline to be consumed by the builders.
     */
    public static HttpPipeline buildHttpPipeline(
        ClientOptions clientOptions,
        HttpLogOptions logOptions,
        Configuration configuration,
        RetryPolicy retryPolicy,
        TokenCredential credential,
        ContainerRegistryAudience audience,
        List<HttpPipelinePolicy> perCallPolicies,
        List<HttpPipelinePolicy> perRetryPolicies,
        HttpClient httpClient,
        String endpoint,
        ContainerRegistryServiceVersion serviceVersion,
        ClientLogger logger) {

        ArrayList<HttpPipelinePolicy> policies = new ArrayList<>();

        policies.add(
            new UserAgentPolicy(CoreUtils.getApplicationId(clientOptions, logOptions), CLIENT_NAME, CLIENT_VERSION, configuration));
        policies.add(new RequestIdPolicy());

        policies.addAll(perCallPolicies);
        HttpPolicyProviders.addBeforeRetryPolicies(policies);

        policies.add(retryPolicy == null ? new RetryPolicy() : retryPolicy);
        policies.add(new CookiePolicy());
        policies.add(new AddDatePolicy());

        policies.addAll(perRetryPolicies);
        HttpPolicyProviders.addAfterRetryPolicies(policies);
        HttpLoggingPolicy loggingPolicy = new HttpLoggingPolicy(logOptions);

        // We generally put credential policy between BeforeRetry and AfterRetry policies and put Logging policy in the end.
        // However since ACR uses the rest endpoints of the service in the credential policy,
        // we want to be able to use the same pipeline (minus the credential policy) to have uniformity in the policy
        // pipelines across all ACR endpoints.
        if (credential == null) {
            logger.verbose("Credentials are null, enabling anonymous access");
        }

        ArrayList<HttpPipelinePolicy> credentialPolicies = clone(policies);
        credentialPolicies.add(loggingPolicy);

        ContainerRegistryTokenService tokenService = new ContainerRegistryTokenService(
            credential,
            audience,
            endpoint,
            serviceVersion,
            new HttpPipelineBuilder()
                .policies(credentialPolicies.toArray(new HttpPipelinePolicy[0]))
                .httpClient(httpClient)
                .build(),
            JacksonAdapter.createDefaultSerializerAdapter());

        ContainerRegistryCredentialsPolicy credentialsPolicy = new ContainerRegistryCredentialsPolicy(tokenService);
        policies.add(credentialsPolicy);

        policies.add(loggingPolicy);
        HttpPipeline httpPipeline =
            new HttpPipelineBuilder()
                .policies(policies.toArray(new HttpPipelinePolicy[0]))
                .httpClient(httpClient)
                .build();
        return httpPipeline;
    }

    private static ArrayList<HttpPipelinePolicy> clone(ArrayList<HttpPipelinePolicy> policies) {
        ArrayList<HttpPipelinePolicy> clonedPolicy = new ArrayList<>();
        for (HttpPipelinePolicy policy:policies) {
            clonedPolicy.add(policy);
        }

        return clonedPolicy;
    }

    /**
     * This method computes the digest for the buffer content.
     * Docker digest is a SHA256 hash of the docker image content and is deterministic based on the image build.
     * @param buffer The buffer containing the image bytes.
     * @return SHA-256 digest for the given buffer.
     */
    public static String computeDigest(ByteBuffer buffer) {
        int startPosition = buffer.position();
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            md.update(buffer);
            byte[] digest = md.digest();
            return "sha256:" + byteArrayToHex(digest);
        } catch (NoSuchAlgorithmException e) {
            // TODO: Should I log this error? or rather just move on and let the method fail.
        } finally {
            buffer.position(startPosition);
        }

        return null;
    }

    private static final char[] HEX_ARRAY = "0123456789abcdef".toCharArray();
    static String byteArrayToHex(byte[] bytes) {
        char[] hexChars = new char[bytes.length * 2];
        for (int byteIndex = 0; byteIndex < bytes.length; byteIndex++) {
            int bits = bytes[byteIndex] & 0xFF;
            hexChars[byteIndex * 2] = HEX_ARRAY[bits >>> 4];
            hexChars[byteIndex * 2 + 1] = HEX_ARRAY[bits & 0x0F];
        }

        return new String(hexChars);
    }

    /**
     * Delete operation should be idempotent.
     * And so should result in a success in case the service response is 400 : Not found.
     * @param responseT The response object.
     * @param <T> The encapsulating value.
     * @return The transformed response object.
     */
    public static <T> Mono<Response<Void>> deleteResponseToSuccess(Response<T> responseT) {
        if (responseT.getStatusCode() != HTTP_STATUS_CODE_NOT_FOUND) {
            // In case of success scenario return Response<Void>.
            return getAcceptedDeleteResponse(responseT, responseT.getStatusCode());
        }

        // In case of 400, we still convert it to success i.e. no-op.
        return getAcceptedDeleteResponse(responseT, HTTP_STATUS_CODE_ACCEPTED);
    }

    static <T> Mono<Response<Void>> getAcceptedDeleteResponse(Response<T> responseT, int statusCode) {
        return Mono.just(new ResponseBase<String, Void>(
            responseT.getRequest(),
            statusCode,
            responseT.getHeaders(),
            null,
            null));
    }

    /**
     * This method converts the API response codes into well known exceptions.
     * @param exception The exception returned by the rest client.
     * @return The exception returned by the public methods.
     */
    public static Throwable mapException(Throwable exception) {
        AcrErrorsException acrException = null;

        if (exception instanceof AcrErrorsException) {
            acrException = ((AcrErrorsException) exception);
        } else if (exception instanceof RuntimeException) {
            RuntimeException runtimeException = (RuntimeException) exception;
            Throwable throwable = runtimeException.getCause();
            if (throwable instanceof AcrErrorsException) {
                acrException = (AcrErrorsException) throwable;
            }
        }

        if (acrException == null) {
            return exception;
        }

        final HttpResponse errorHttpResponse = acrException.getResponse();
        final int statusCode = errorHttpResponse.getStatusCode();
        final String errorDetail = acrException.getMessage();

        switch (statusCode) {
            case 401:
                return new ClientAuthenticationException(errorDetail, acrException.getResponse(), exception);
            case 404:
                return new ResourceNotFoundException(errorDetail, acrException.getResponse(), exception);
            case 409:
                return new ResourceExistsException(errorDetail, acrException.getResponse(), exception);
            case 412:
                return new ResourceModifiedException(errorDetail, acrException.getResponse(), exception);
            default:
                return new HttpResponseException(errorDetail, acrException.getResponse(), exception);
        }
    }
}
