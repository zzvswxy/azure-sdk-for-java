// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.resources.fluent.models;

import com.azure.core.annotation.Fluent;
import com.azure.resourcemanager.resources.models.EnforcementMode;
import com.azure.resourcemanager.resources.models.NonComplianceMessage;
import com.azure.resourcemanager.resources.models.ParameterValuesValue;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import java.util.Map;

/** The policy assignment properties. */
@Fluent
public final class PolicyAssignmentProperties {
    /*
     * The display name of the policy assignment.
     */
    @JsonProperty(value = "displayName")
    private String displayName;

    /*
     * The ID of the policy definition or policy set definition being assigned.
     */
    @JsonProperty(value = "policyDefinitionId")
    private String policyDefinitionId;

    /*
     * The scope for the policy assignment.
     */
    @JsonProperty(value = "scope", access = JsonProperty.Access.WRITE_ONLY)
    private String scope;

    /*
     * The policy's excluded scopes.
     */
    @JsonProperty(value = "notScopes")
    private List<String> notScopes;

    /*
     * The parameter values for the assigned policy rule. The keys are the
     * parameter names.
     */
    @JsonProperty(value = "parameters")
    @JsonInclude(value = JsonInclude.Include.NON_NULL, content = JsonInclude.Include.ALWAYS)
    private Map<String, ParameterValuesValue> parameters;

    /*
     * This message will be part of response in case of policy violation.
     */
    @JsonProperty(value = "description")
    private String description;

    /*
     * The policy assignment metadata. Metadata is an open ended object and is
     * typically a collection of key value pairs.
     */
    @JsonProperty(value = "metadata")
    private Object metadata;

    /*
     * The policy assignment enforcement mode. Possible values are Default and
     * DoNotEnforce.
     */
    @JsonProperty(value = "enforcementMode")
    private EnforcementMode enforcementMode;

    /*
     * The messages that describe why a resource is non-compliant with the
     * policy.
     */
    @JsonProperty(value = "nonComplianceMessages")
    private List<NonComplianceMessage> nonComplianceMessages;

    /**
     * Get the displayName property: The display name of the policy assignment.
     *
     * @return the displayName value.
     */
    public String displayName() {
        return this.displayName;
    }

    /**
     * Set the displayName property: The display name of the policy assignment.
     *
     * @param displayName the displayName value to set.
     * @return the PolicyAssignmentProperties object itself.
     */
    public PolicyAssignmentProperties withDisplayName(String displayName) {
        this.displayName = displayName;
        return this;
    }

    /**
     * Get the policyDefinitionId property: The ID of the policy definition or policy set definition being assigned.
     *
     * @return the policyDefinitionId value.
     */
    public String policyDefinitionId() {
        return this.policyDefinitionId;
    }

    /**
     * Set the policyDefinitionId property: The ID of the policy definition or policy set definition being assigned.
     *
     * @param policyDefinitionId the policyDefinitionId value to set.
     * @return the PolicyAssignmentProperties object itself.
     */
    public PolicyAssignmentProperties withPolicyDefinitionId(String policyDefinitionId) {
        this.policyDefinitionId = policyDefinitionId;
        return this;
    }

    /**
     * Get the scope property: The scope for the policy assignment.
     *
     * @return the scope value.
     */
    public String scope() {
        return this.scope;
    }

    /**
     * Get the notScopes property: The policy's excluded scopes.
     *
     * @return the notScopes value.
     */
    public List<String> notScopes() {
        return this.notScopes;
    }

    /**
     * Set the notScopes property: The policy's excluded scopes.
     *
     * @param notScopes the notScopes value to set.
     * @return the PolicyAssignmentProperties object itself.
     */
    public PolicyAssignmentProperties withNotScopes(List<String> notScopes) {
        this.notScopes = notScopes;
        return this;
    }

    /**
     * Get the parameters property: The parameter values for the assigned policy rule. The keys are the parameter names.
     *
     * @return the parameters value.
     */
    public Map<String, ParameterValuesValue> parameters() {
        return this.parameters;
    }

    /**
     * Set the parameters property: The parameter values for the assigned policy rule. The keys are the parameter names.
     *
     * @param parameters the parameters value to set.
     * @return the PolicyAssignmentProperties object itself.
     */
    public PolicyAssignmentProperties withParameters(Map<String, ParameterValuesValue> parameters) {
        this.parameters = parameters;
        return this;
    }

    /**
     * Get the description property: This message will be part of response in case of policy violation.
     *
     * @return the description value.
     */
    public String description() {
        return this.description;
    }

    /**
     * Set the description property: This message will be part of response in case of policy violation.
     *
     * @param description the description value to set.
     * @return the PolicyAssignmentProperties object itself.
     */
    public PolicyAssignmentProperties withDescription(String description) {
        this.description = description;
        return this;
    }

    /**
     * Get the metadata property: The policy assignment metadata. Metadata is an open ended object and is typically a
     * collection of key value pairs.
     *
     * @return the metadata value.
     */
    public Object metadata() {
        return this.metadata;
    }

    /**
     * Set the metadata property: The policy assignment metadata. Metadata is an open ended object and is typically a
     * collection of key value pairs.
     *
     * @param metadata the metadata value to set.
     * @return the PolicyAssignmentProperties object itself.
     */
    public PolicyAssignmentProperties withMetadata(Object metadata) {
        this.metadata = metadata;
        return this;
    }

    /**
     * Get the enforcementMode property: The policy assignment enforcement mode. Possible values are Default and
     * DoNotEnforce.
     *
     * @return the enforcementMode value.
     */
    public EnforcementMode enforcementMode() {
        return this.enforcementMode;
    }

    /**
     * Set the enforcementMode property: The policy assignment enforcement mode. Possible values are Default and
     * DoNotEnforce.
     *
     * @param enforcementMode the enforcementMode value to set.
     * @return the PolicyAssignmentProperties object itself.
     */
    public PolicyAssignmentProperties withEnforcementMode(EnforcementMode enforcementMode) {
        this.enforcementMode = enforcementMode;
        return this;
    }

    /**
     * Get the nonComplianceMessages property: The messages that describe why a resource is non-compliant with the
     * policy.
     *
     * @return the nonComplianceMessages value.
     */
    public List<NonComplianceMessage> nonComplianceMessages() {
        return this.nonComplianceMessages;
    }

    /**
     * Set the nonComplianceMessages property: The messages that describe why a resource is non-compliant with the
     * policy.
     *
     * @param nonComplianceMessages the nonComplianceMessages value to set.
     * @return the PolicyAssignmentProperties object itself.
     */
    public PolicyAssignmentProperties withNonComplianceMessages(List<NonComplianceMessage> nonComplianceMessages) {
        this.nonComplianceMessages = nonComplianceMessages;
        return this;
    }

    /**
     * Validates the instance.
     *
     * @throws IllegalArgumentException thrown if the instance is not valid.
     */
    public void validate() {
        if (parameters() != null) {
            parameters()
                .values()
                .forEach(
                    e -> {
                        if (e != null) {
                            e.validate();
                        }
                    });
        }
        if (nonComplianceMessages() != null) {
            nonComplianceMessages().forEach(e -> e.validate());
        }
    }
}
