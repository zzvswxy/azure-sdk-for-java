// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.signalr.fluent.models;

import com.azure.core.annotation.Fluent;
import com.azure.resourcemanager.signalr.models.OperationDisplay;
import com.azure.resourcemanager.signalr.models.OperationProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/** REST API operation supported by resource provider. */
@Fluent
public final class OperationInner {
    /*
     * Name of the operation with format: {provider}/{resource}/{operation}
     */
    @JsonProperty(value = "name")
    private String name;

    /*
     * If the operation is a data action. (for data plane rbac)
     */
    @JsonProperty(value = "isDataAction")
    private Boolean isDataAction;

    /*
     * The object that describes a operation.
     */
    @JsonProperty(value = "display")
    private OperationDisplay display;

    /*
     * Optional. The intended executor of the operation; governs the display of
     * the operation in the RBAC UX and the audit logs UX.
     */
    @JsonProperty(value = "origin")
    private String origin;

    /*
     * Extra Operation properties.
     */
    @JsonProperty(value = "properties")
    private OperationProperties properties;

    /**
     * Get the name property: Name of the operation with format: {provider}/{resource}/{operation}.
     *
     * @return the name value.
     */
    public String name() {
        return this.name;
    }

    /**
     * Set the name property: Name of the operation with format: {provider}/{resource}/{operation}.
     *
     * @param name the name value to set.
     * @return the OperationInner object itself.
     */
    public OperationInner withName(String name) {
        this.name = name;
        return this;
    }

    /**
     * Get the isDataAction property: If the operation is a data action. (for data plane rbac).
     *
     * @return the isDataAction value.
     */
    public Boolean isDataAction() {
        return this.isDataAction;
    }

    /**
     * Set the isDataAction property: If the operation is a data action. (for data plane rbac).
     *
     * @param isDataAction the isDataAction value to set.
     * @return the OperationInner object itself.
     */
    public OperationInner withIsDataAction(Boolean isDataAction) {
        this.isDataAction = isDataAction;
        return this;
    }

    /**
     * Get the display property: The object that describes a operation.
     *
     * @return the display value.
     */
    public OperationDisplay display() {
        return this.display;
    }

    /**
     * Set the display property: The object that describes a operation.
     *
     * @param display the display value to set.
     * @return the OperationInner object itself.
     */
    public OperationInner withDisplay(OperationDisplay display) {
        this.display = display;
        return this;
    }

    /**
     * Get the origin property: Optional. The intended executor of the operation; governs the display of the operation
     * in the RBAC UX and the audit logs UX.
     *
     * @return the origin value.
     */
    public String origin() {
        return this.origin;
    }

    /**
     * Set the origin property: Optional. The intended executor of the operation; governs the display of the operation
     * in the RBAC UX and the audit logs UX.
     *
     * @param origin the origin value to set.
     * @return the OperationInner object itself.
     */
    public OperationInner withOrigin(String origin) {
        this.origin = origin;
        return this;
    }

    /**
     * Get the properties property: Extra Operation properties.
     *
     * @return the properties value.
     */
    public OperationProperties properties() {
        return this.properties;
    }

    /**
     * Set the properties property: Extra Operation properties.
     *
     * @param properties the properties value to set.
     * @return the OperationInner object itself.
     */
    public OperationInner withProperties(OperationProperties properties) {
        this.properties = properties;
        return this;
    }

    /**
     * Validates the instance.
     *
     * @throws IllegalArgumentException thrown if the instance is not valid.
     */
    public void validate() {
        if (display() != null) {
            display().validate();
        }
        if (properties() != null) {
            properties().validate();
        }
    }
}
