// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.ai.personalizer.implementation.models;

import com.azure.core.util.ExpandableStringEnum;
import com.fasterxml.jackson.annotation.JsonCreator;
import java.util.Collection;

/** Defines values for PolicySource. */
public final class PolicySource extends ExpandableStringEnum<PolicySource> {
    /** Static value Online for PolicySource. */
    public static final PolicySource ONLINE = fromString("Online");

    /** Static value Baseline for PolicySource. */
    public static final PolicySource BASELINE = fromString("Baseline");

    /** Static value Random for PolicySource. */
    public static final PolicySource RANDOM = fromString("Random");

    /** Static value Custom for PolicySource. */
    public static final PolicySource CUSTOM = fromString("Custom");

    /** Static value OfflineExperimentation for PolicySource. */
    public static final PolicySource OFFLINE_EXPERIMENTATION = fromString("OfflineExperimentation");

    /**
     * Creates or finds a PolicySource from its string representation.
     *
     * @param name a name to look for.
     * @return the corresponding PolicySource.
     */
    @JsonCreator
    public static PolicySource fromString(String name) {
        return fromString(name, PolicySource.class);
    }

    /** @return known PolicySource values. */
    public static Collection<PolicySource> values() {
        return values(PolicySource.class);
    }
}
