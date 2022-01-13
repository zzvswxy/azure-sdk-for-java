// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.

package com.azure.containers.containerregistry;

import com.azure.containers.containerregistry.implementation.models.AcrErrorsException;
import com.azure.core.exception.ClientAuthenticationException;
import com.azure.core.exception.HttpResponseException;
import com.azure.core.exception.ResourceExistsException;
import com.azure.core.exception.ResourceModifiedException;
import com.azure.core.exception.ResourceNotFoundException;
import com.azure.core.http.HttpHeaders;
import com.azure.core.http.HttpResponse;
import com.azure.core.http.rest.PagedResponse;
import com.azure.core.http.rest.PagedResponseBase;
import com.azure.core.http.rest.Response;
import com.azure.core.http.rest.ResponseBase;
import com.azure.core.util.CoreUtils;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * This is the utility class that includes helper methods used across our clients.
 */
final class Utils {
    private static final String CONTINUATIONLINK_HEADER_NAME;
    private static final Pattern CONTINUATIONLINK_PATTERN;
    private static final int HTTP_STATUS_CODE_NOT_FOUND = 404;
    private static final int HTTP_STATUS_CODE_ACCEPTED = 202;
    static final String CONTAINER_REGISTRY_TRACING_NAMESPACE_VALUE = "Microsoft.ContainerRegistry";

    static {
        Map<String, String> properties = CoreUtils.getProperties("azure-containers-containerregistry.properties");

        CONTINUATIONLINK_HEADER_NAME = "Link";
        CONTINUATIONLINK_PATTERN = Pattern.compile("<(.+)>;.*");
    }

    /**
     * This method parses the response to get the continuation token used to make the next pagination call.
     * The continuation token is returned by the service in the form of a header and not as a nextLink field.
     * @param listResponse response that is parsed.
     * @param <T> the model type that is being operated on.
     * @return paged response with the correct continuation token.
     */
    static <T> PagedResponse<T> getPagedResponseWithContinuationToken(PagedResponse<T> listResponse) {
        return Utils.getPagedResponseWithContinuationToken(listResponse, values -> values);
    }

    /**
     * This method parses the response to get the continuation token used to make the next pagination call.
     * The continuation token is returned by the service in the form of a header and not as a nextLink field.
     *
     * <p>
     *      Per the Docker v2 HTTP API spec, the Link header is an RFC5988
     *      compliant rel='next' with URL to next result set, if available.
     *      See: https://docs.docker.com/registry/spec/api/
     *
     *      The URI reference can be obtained from link-value as follows:
     *        Link       = "Link" ":" #link-value
     *        link-value = "<" URI-Reference ">" * (";" link-param )
     *      See: https://tools.ietf.org/html/rfc5988#section-5
     * </p>
     * @param listResponse response that is parsed.
     * @param mapperFunction the function that maps the rest api response into the public model exposed by the client.
     * @param <T> The model type returned by the rest client.
     * @param <R> The model type returned by the public client.
     * @return paged response with the correct continuation token.
     */

    static <T, R> PagedResponse<T> getPagedResponseWithContinuationToken(PagedResponse<R> listResponse, Function<List<R>, List<T>> mapperFunction) {
        Objects.requireNonNull(mapperFunction);

        String continuationLink = null;
        HttpHeaders headers = listResponse.getHeaders();

        if (headers != null) {
            String continuationLinkHeader = headers.getValue(CONTINUATIONLINK_HEADER_NAME);
            if (!CoreUtils.isNullOrEmpty(continuationLinkHeader)) {
                Matcher matcher = CONTINUATIONLINK_PATTERN.matcher(continuationLinkHeader);
                if (matcher.matches()) {
                    if (matcher.groupCount() == 1) {
                        continuationLink = matcher.group(1);
                    }
                }
            }
        }

        List<T> values = mapperFunction.apply(listResponse.getValue());

        return new PagedResponseBase<String, T>(
            listResponse.getRequest(),
            listResponse.getStatusCode(),
            listResponse.getHeaders(),
            values,
            continuationLink,
            null
        );
    }

    /**
     * This method converts the API response codes into well known exceptions.
     * @param exception The exception returned by the rest client.
     * @return The exception returned by the public methods.
     */
    static Throwable mapException(Throwable exception) {
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

    static <T> Mono<Response<Void>> deleteResponseToSuccess(Response<T> responseT) {
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
}
