// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.ai.personalizer.implementation.models;

import com.azure.core.annotation.Fluent;
import com.fasterxml.jackson.annotation.JsonProperty;

/** The SlotReward model. */
@Fluent
public final class SlotReward {
    /*
     * Slot id for which we are sending the reward.
     */
    @JsonProperty(value = "slotId", required = true)
    private String slotId;

    /*
     * Reward to be assigned to slotId. Value should be between -1 and 1
     * inclusive.
     */
    @JsonProperty(value = "value", required = true)
    private float value;

    /**
     * Get the slotId property: Slot id for which we are sending the reward.
     *
     * @return the slotId value.
     */
    public String getSlotId() {
        return this.slotId;
    }

    /**
     * Set the slotId property: Slot id for which we are sending the reward.
     *
     * @param slotId the slotId value to set.
     * @return the SlotReward object itself.
     */
    public SlotReward setSlotId(String slotId) {
        this.slotId = slotId;
        return this;
    }

    /**
     * Get the value property: Reward to be assigned to slotId. Value should be between -1 and 1 inclusive.
     *
     * @return the value value.
     */
    public float getValue() {
        return this.value;
    }

    /**
     * Set the value property: Reward to be assigned to slotId. Value should be between -1 and 1 inclusive.
     *
     * @param value the value value to set.
     * @return the SlotReward object itself.
     */
    public SlotReward setValue(float value) {
        this.value = value;
        return this;
    }
}
