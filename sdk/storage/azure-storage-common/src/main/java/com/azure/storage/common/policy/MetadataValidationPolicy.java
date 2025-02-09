// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.

package com.azure.storage.common.policy;

import com.azure.core.http.HttpPipelineCallContext;
import com.azure.core.http.HttpPipelineNextPolicy;
import com.azure.core.http.HttpResponse;
import com.azure.core.http.policy.HttpPipelinePolicy;
import com.azure.core.util.FluxUtil;
import com.azure.core.util.logging.ClientLogger;
import com.azure.storage.common.implementation.Constants;
import reactor.core.publisher.Mono;

import java.util.Locale;

/**
 * This is a request policy in an {@link com.azure.core.http.HttpPipeline} to validate that metadata does not contain
 * leading or trailing whitespace characters.
 * We do this since the service trims whitespace for the string to sign, but the client does not, resulting in an auth
 * failure.
 */
public class MetadataValidationPolicy implements HttpPipelinePolicy {
    private static final ClientLogger LOGGER = new ClientLogger(MetadataValidationPolicy.class);
    private static final int X_MS_META_LENGTH = Constants.HeaderConstants.X_MS_META.length();

    @Override
    public Mono<HttpResponse> process(HttpPipelineCallContext context, HttpPipelineNextPolicy next) {
        try {
            context.getHttpRequest().getHeaders().stream()
                .filter(header -> header.getName().toLowerCase(Locale.ROOT)
                    .startsWith(Constants.HeaderConstants.X_MS_META))
                .forEach(header -> {
                    String name = header.getName();
                    String value = header.getValue();
                    boolean foundWhitespace = Character.isWhitespace(name.charAt(X_MS_META_LENGTH))
                        || Character.isWhitespace(name.charAt(name.length() - 1))
                        || Character.isWhitespace(value.charAt(0))
                        || Character.isWhitespace(value.charAt(value.length() - 1));
                    if (foundWhitespace) {
                        throw LOGGER.logExceptionAsError(new IllegalArgumentException("Metadata keys and values "
                            + "can not contain leading or trailing whitespace. Please remove or encode them."));
                    }
                });
        } catch (IllegalArgumentException ex) {
            return FluxUtil.monoError(LOGGER, ex);
        }

        return next.process();
    }
}
