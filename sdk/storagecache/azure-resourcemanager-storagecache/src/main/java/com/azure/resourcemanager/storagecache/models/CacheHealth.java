// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.storagecache.models;

import com.azure.core.annotation.Fluent;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

/** An indication of Cache health. Gives more information about health than just that related to provisioning. */
@Fluent
public final class CacheHealth {
    /*
     * List of Cache health states.
     */
    @JsonProperty(value = "state")
    private HealthStateType state;

    /*
     * Describes explanation of state.
     */
    @JsonProperty(value = "statusDescription")
    private String statusDescription;

    /*
     * Outstanding conditions that need to be investigated and resolved.
     */
    @JsonProperty(value = "conditions", access = JsonProperty.Access.WRITE_ONLY)
    private List<Condition> conditions;

    /**
     * Get the state property: List of Cache health states.
     *
     * @return the state value.
     */
    public HealthStateType state() {
        return this.state;
    }

    /**
     * Set the state property: List of Cache health states.
     *
     * @param state the state value to set.
     * @return the CacheHealth object itself.
     */
    public CacheHealth withState(HealthStateType state) {
        this.state = state;
        return this;
    }

    /**
     * Get the statusDescription property: Describes explanation of state.
     *
     * @return the statusDescription value.
     */
    public String statusDescription() {
        return this.statusDescription;
    }

    /**
     * Set the statusDescription property: Describes explanation of state.
     *
     * @param statusDescription the statusDescription value to set.
     * @return the CacheHealth object itself.
     */
    public CacheHealth withStatusDescription(String statusDescription) {
        this.statusDescription = statusDescription;
        return this;
    }

    /**
     * Get the conditions property: Outstanding conditions that need to be investigated and resolved.
     *
     * @return the conditions value.
     */
    public List<Condition> conditions() {
        return this.conditions;
    }

    /**
     * Validates the instance.
     *
     * @throws IllegalArgumentException thrown if the instance is not valid.
     */
    public void validate() {
        if (conditions() != null) {
            conditions().forEach(e -> e.validate());
        }
    }
}
