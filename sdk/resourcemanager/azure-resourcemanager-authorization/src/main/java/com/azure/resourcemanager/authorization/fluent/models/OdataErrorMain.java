// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.authorization.fluent.models;

import com.azure.core.annotation.Immutable;
import com.azure.core.management.exception.ManagementError;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Map;

/** The OdataErrorMain model. */
@Immutable
public final class OdataErrorMain extends ManagementError {
    /*
     * The structure of this object is service-specific
     */
    @JsonProperty(value = "innererror", access = JsonProperty.Access.WRITE_ONLY)
    @JsonInclude(value = JsonInclude.Include.NON_NULL, content = JsonInclude.Include.ALWAYS)
    private Map<String, Object> innererror;

    /**
     * Get the innererror property: The structure of this object is service-specific.
     *
     * @return the innererror value.
     */
    public Map<String, Object> getInnererror() {
        return this.innererror;
    }

    /**
     * Validates the instance.
     *
     * @throws IllegalArgumentException thrown if the instance is not valid.
     */
    public void validate() {
    }
}
