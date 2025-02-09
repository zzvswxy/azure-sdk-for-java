// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.storagecache.fluent.models;

import com.azure.core.annotation.Immutable;
import com.azure.resourcemanager.storagecache.models.ResourceUsageName;
import com.fasterxml.jackson.annotation.JsonProperty;

/** The usage and limit (quota) for a resource. */
@Immutable
public final class ResourceUsageInner {
    /*
     * The limit (quota) for this resource.
     */
    @JsonProperty(value = "limit", access = JsonProperty.Access.WRITE_ONLY)
    private Integer limit;

    /*
     * Unit that the limit and usages are expressed in, such as 'Count'.
     */
    @JsonProperty(value = "unit", access = JsonProperty.Access.WRITE_ONLY)
    private String unit;

    /*
     * The current usage of this resource.
     */
    @JsonProperty(value = "currentValue", access = JsonProperty.Access.WRITE_ONLY)
    private Integer currentValue;

    /*
     * Naming information for this resource type.
     */
    @JsonProperty(value = "name", access = JsonProperty.Access.WRITE_ONLY)
    private ResourceUsageName name;

    /**
     * Get the limit property: The limit (quota) for this resource.
     *
     * @return the limit value.
     */
    public Integer limit() {
        return this.limit;
    }

    /**
     * Get the unit property: Unit that the limit and usages are expressed in, such as 'Count'.
     *
     * @return the unit value.
     */
    public String unit() {
        return this.unit;
    }

    /**
     * Get the currentValue property: The current usage of this resource.
     *
     * @return the currentValue value.
     */
    public Integer currentValue() {
        return this.currentValue;
    }

    /**
     * Get the name property: Naming information for this resource type.
     *
     * @return the name value.
     */
    public ResourceUsageName name() {
        return this.name;
    }

    /**
     * Validates the instance.
     *
     * @throws IllegalArgumentException thrown if the instance is not valid.
     */
    public void validate() {
        if (name() != null) {
            name().validate();
        }
    }
}
