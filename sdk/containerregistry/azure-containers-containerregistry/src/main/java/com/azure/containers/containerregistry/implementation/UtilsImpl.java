// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.

package com.azure.containers.containerregistry.implementation;

import com.azure.containers.containerregistry.implementation.authentication.ContainerRegistryCredentialsPolicy;
import com.azure.containers.containerregistry.ContainerRegistryServiceVersion;
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
import com.azure.core.http.HttpHeaders;
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
import com.azure.core.http.rest.PagedResponse;
import com.azure.core.http.rest.PagedResponseBase;
import com.azure.core.http.rest.Response;
import com.azure.core.http.rest.ResponseBase;
import com.azure.core.util.ClientOptions;
import com.azure.core.util.Configuration;
import com.azure.core.util.CoreUtils;
import com.azure.core.util.logging.ClientLogger;
import com.azure.core.util.serializer.JacksonAdapter;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * This is the utility class that includes helper methods used across our clients.
 */
public final class UtilsImpl {
    private static final String CLIENT_NAME;
    private static final String CLIENT_VERSION;

    static {
        Map<String, String> properties = CoreUtils.getProperties("azure-containers-containerregistry.properties");
        CLIENT_NAME = properties.getOrDefault("name", "UnknownName");
        CLIENT_VERSION = properties.getOrDefault("version", "UnknownVersion");
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
}
