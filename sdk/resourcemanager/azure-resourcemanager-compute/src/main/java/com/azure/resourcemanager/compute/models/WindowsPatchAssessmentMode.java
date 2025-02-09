// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.compute.models;

import com.azure.core.util.ExpandableStringEnum;
import com.fasterxml.jackson.annotation.JsonCreator;
import java.util.Collection;

/** Defines values for WindowsPatchAssessmentMode. */
public final class WindowsPatchAssessmentMode extends ExpandableStringEnum<WindowsPatchAssessmentMode> {
    /** Static value ImageDefault for WindowsPatchAssessmentMode. */
    public static final WindowsPatchAssessmentMode IMAGE_DEFAULT = fromString("ImageDefault");

    /** Static value AutomaticByPlatform for WindowsPatchAssessmentMode. */
    public static final WindowsPatchAssessmentMode AUTOMATIC_BY_PLATFORM = fromString("AutomaticByPlatform");

    /**
     * Creates or finds a WindowsPatchAssessmentMode from its string representation.
     *
     * @param name a name to look for.
     * @return the corresponding WindowsPatchAssessmentMode.
     */
    @JsonCreator
    public static WindowsPatchAssessmentMode fromString(String name) {
        return fromString(name, WindowsPatchAssessmentMode.class);
    }

    /**
     * Gets known WindowsPatchAssessmentMode values.
     *
     * @return known WindowsPatchAssessmentMode values.
     */
    public static Collection<WindowsPatchAssessmentMode> values() {
        return values(WindowsPatchAssessmentMode.class);
    }
}
