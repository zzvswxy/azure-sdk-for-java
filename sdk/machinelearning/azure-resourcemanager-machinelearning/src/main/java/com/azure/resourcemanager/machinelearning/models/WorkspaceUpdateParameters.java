// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.machinelearning.models;

import com.azure.core.annotation.Fluent;
import com.azure.resourcemanager.machinelearning.fluent.models.WorkspacePropertiesUpdateParameters;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Map;

/** The parameters for updating a machine learning workspace. */
@Fluent
public final class WorkspaceUpdateParameters {
    /*
     * The resource tags for the machine learning workspace.
     */
    @JsonProperty(value = "tags")
    @JsonInclude(value = JsonInclude.Include.NON_NULL, content = JsonInclude.Include.ALWAYS)
    private Map<String, String> tags;

    /*
     * The sku of the workspace.
     */
    @JsonProperty(value = "sku")
    private Sku sku;

    /*
     * The identity of the resource.
     */
    @JsonProperty(value = "identity")
    private ManagedServiceIdentity identity;

    /*
     * The properties that the machine learning workspace will be updated with.
     */
    @JsonProperty(value = "properties")
    private WorkspacePropertiesUpdateParameters innerProperties;

    /**
     * Get the tags property: The resource tags for the machine learning workspace.
     *
     * @return the tags value.
     */
    public Map<String, String> tags() {
        return this.tags;
    }

    /**
     * Set the tags property: The resource tags for the machine learning workspace.
     *
     * @param tags the tags value to set.
     * @return the WorkspaceUpdateParameters object itself.
     */
    public WorkspaceUpdateParameters withTags(Map<String, String> tags) {
        this.tags = tags;
        return this;
    }

    /**
     * Get the sku property: The sku of the workspace.
     *
     * @return the sku value.
     */
    public Sku sku() {
        return this.sku;
    }

    /**
     * Set the sku property: The sku of the workspace.
     *
     * @param sku the sku value to set.
     * @return the WorkspaceUpdateParameters object itself.
     */
    public WorkspaceUpdateParameters withSku(Sku sku) {
        this.sku = sku;
        return this;
    }

    /**
     * Get the identity property: The identity of the resource.
     *
     * @return the identity value.
     */
    public ManagedServiceIdentity identity() {
        return this.identity;
    }

    /**
     * Set the identity property: The identity of the resource.
     *
     * @param identity the identity value to set.
     * @return the WorkspaceUpdateParameters object itself.
     */
    public WorkspaceUpdateParameters withIdentity(ManagedServiceIdentity identity) {
        this.identity = identity;
        return this;
    }

    /**
     * Get the innerProperties property: The properties that the machine learning workspace will be updated with.
     *
     * @return the innerProperties value.
     */
    private WorkspacePropertiesUpdateParameters innerProperties() {
        return this.innerProperties;
    }

    /**
     * Get the description property: The description of this workspace.
     *
     * @return the description value.
     */
    public String description() {
        return this.innerProperties() == null ? null : this.innerProperties().description();
    }

    /**
     * Set the description property: The description of this workspace.
     *
     * @param description the description value to set.
     * @return the WorkspaceUpdateParameters object itself.
     */
    public WorkspaceUpdateParameters withDescription(String description) {
        if (this.innerProperties() == null) {
            this.innerProperties = new WorkspacePropertiesUpdateParameters();
        }
        this.innerProperties().withDescription(description);
        return this;
    }

    /**
     * Get the friendlyName property: The friendly name for this workspace.
     *
     * @return the friendlyName value.
     */
    public String friendlyName() {
        return this.innerProperties() == null ? null : this.innerProperties().friendlyName();
    }

    /**
     * Set the friendlyName property: The friendly name for this workspace.
     *
     * @param friendlyName the friendlyName value to set.
     * @return the WorkspaceUpdateParameters object itself.
     */
    public WorkspaceUpdateParameters withFriendlyName(String friendlyName) {
        if (this.innerProperties() == null) {
            this.innerProperties = new WorkspacePropertiesUpdateParameters();
        }
        this.innerProperties().withFriendlyName(friendlyName);
        return this;
    }

    /**
     * Get the imageBuildCompute property: The compute name for image build.
     *
     * @return the imageBuildCompute value.
     */
    public String imageBuildCompute() {
        return this.innerProperties() == null ? null : this.innerProperties().imageBuildCompute();
    }

    /**
     * Set the imageBuildCompute property: The compute name for image build.
     *
     * @param imageBuildCompute the imageBuildCompute value to set.
     * @return the WorkspaceUpdateParameters object itself.
     */
    public WorkspaceUpdateParameters withImageBuildCompute(String imageBuildCompute) {
        if (this.innerProperties() == null) {
            this.innerProperties = new WorkspacePropertiesUpdateParameters();
        }
        this.innerProperties().withImageBuildCompute(imageBuildCompute);
        return this;
    }

    /**
     * Get the serviceManagedResourcesSettings property: The service managed resource settings.
     *
     * @return the serviceManagedResourcesSettings value.
     */
    public ServiceManagedResourcesSettings serviceManagedResourcesSettings() {
        return this.innerProperties() == null ? null : this.innerProperties().serviceManagedResourcesSettings();
    }

    /**
     * Set the serviceManagedResourcesSettings property: The service managed resource settings.
     *
     * @param serviceManagedResourcesSettings the serviceManagedResourcesSettings value to set.
     * @return the WorkspaceUpdateParameters object itself.
     */
    public WorkspaceUpdateParameters withServiceManagedResourcesSettings(
        ServiceManagedResourcesSettings serviceManagedResourcesSettings) {
        if (this.innerProperties() == null) {
            this.innerProperties = new WorkspacePropertiesUpdateParameters();
        }
        this.innerProperties().withServiceManagedResourcesSettings(serviceManagedResourcesSettings);
        return this;
    }

    /**
     * Get the primaryUserAssignedIdentity property: The user assigned identity resource id that represents the
     * workspace identity.
     *
     * @return the primaryUserAssignedIdentity value.
     */
    public String primaryUserAssignedIdentity() {
        return this.innerProperties() == null ? null : this.innerProperties().primaryUserAssignedIdentity();
    }

    /**
     * Set the primaryUserAssignedIdentity property: The user assigned identity resource id that represents the
     * workspace identity.
     *
     * @param primaryUserAssignedIdentity the primaryUserAssignedIdentity value to set.
     * @return the WorkspaceUpdateParameters object itself.
     */
    public WorkspaceUpdateParameters withPrimaryUserAssignedIdentity(String primaryUserAssignedIdentity) {
        if (this.innerProperties() == null) {
            this.innerProperties = new WorkspacePropertiesUpdateParameters();
        }
        this.innerProperties().withPrimaryUserAssignedIdentity(primaryUserAssignedIdentity);
        return this;
    }

    /**
     * Get the publicNetworkAccess property: Whether requests from Public Network are allowed.
     *
     * @return the publicNetworkAccess value.
     */
    public PublicNetworkAccess publicNetworkAccess() {
        return this.innerProperties() == null ? null : this.innerProperties().publicNetworkAccess();
    }

    /**
     * Set the publicNetworkAccess property: Whether requests from Public Network are allowed.
     *
     * @param publicNetworkAccess the publicNetworkAccess value to set.
     * @return the WorkspaceUpdateParameters object itself.
     */
    public WorkspaceUpdateParameters withPublicNetworkAccess(PublicNetworkAccess publicNetworkAccess) {
        if (this.innerProperties() == null) {
            this.innerProperties = new WorkspacePropertiesUpdateParameters();
        }
        this.innerProperties().withPublicNetworkAccess(publicNetworkAccess);
        return this;
    }

    /**
     * Get the applicationInsights property: ARM id of the application insights associated with this workspace.
     *
     * @return the applicationInsights value.
     */
    public String applicationInsights() {
        return this.innerProperties() == null ? null : this.innerProperties().applicationInsights();
    }

    /**
     * Set the applicationInsights property: ARM id of the application insights associated with this workspace.
     *
     * @param applicationInsights the applicationInsights value to set.
     * @return the WorkspaceUpdateParameters object itself.
     */
    public WorkspaceUpdateParameters withApplicationInsights(String applicationInsights) {
        if (this.innerProperties() == null) {
            this.innerProperties = new WorkspacePropertiesUpdateParameters();
        }
        this.innerProperties().withApplicationInsights(applicationInsights);
        return this;
    }

    /**
     * Get the containerRegistry property: ARM id of the container registry associated with this workspace.
     *
     * @return the containerRegistry value.
     */
    public String containerRegistry() {
        return this.innerProperties() == null ? null : this.innerProperties().containerRegistry();
    }

    /**
     * Set the containerRegistry property: ARM id of the container registry associated with this workspace.
     *
     * @param containerRegistry the containerRegistry value to set.
     * @return the WorkspaceUpdateParameters object itself.
     */
    public WorkspaceUpdateParameters withContainerRegistry(String containerRegistry) {
        if (this.innerProperties() == null) {
            this.innerProperties = new WorkspacePropertiesUpdateParameters();
        }
        this.innerProperties().withContainerRegistry(containerRegistry);
        return this;
    }

    /**
     * Validates the instance.
     *
     * @throws IllegalArgumentException thrown if the instance is not valid.
     */
    public void validate() {
        if (sku() != null) {
            sku().validate();
        }
        if (identity() != null) {
            identity().validate();
        }
        if (innerProperties() != null) {
            innerProperties().validate();
        }
    }
}
