// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.storage.models;

import com.azure.core.util.ExpandableStringEnum;
import com.fasterxml.jackson.annotation.JsonCreator;
import java.util.Collection;

/** Defines values for SignedResourceTypes. */
public final class SignedResourceTypes extends ExpandableStringEnum<SignedResourceTypes> {
    /** Static value s for SignedResourceTypes. */
    public static final SignedResourceTypes S = fromString("s");

    /** Static value c for SignedResourceTypes. */
    public static final SignedResourceTypes C = fromString("c");

    /** Static value o for SignedResourceTypes. */
    public static final SignedResourceTypes O = fromString("o");

    /**
     * Creates or finds a SignedResourceTypes from its string representation.
     *
     * @param name a name to look for.
     * @return the corresponding SignedResourceTypes.
     */
    @JsonCreator
    public static SignedResourceTypes fromString(String name) {
        return fromString(name, SignedResourceTypes.class);
    }

    /**
     * Gets known SignedResourceTypes values.
     *
     * @return known SignedResourceTypes values.
     */
    public static Collection<SignedResourceTypes> values() {
        return values(SignedResourceTypes.class);
    }
}
