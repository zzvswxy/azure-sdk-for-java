// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.netapp.fluent.models;

import com.azure.core.annotation.Fluent;
import com.azure.core.management.Resource;
import com.azure.resourcemanager.netapp.models.AccountEncryption;
import com.azure.resourcemanager.netapp.models.ActiveDirectory;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import java.util.Map;

/** NetApp account resource. */
@Fluent
public final class NetAppAccountInner extends Resource {
    /*
     * A unique read-only string that changes whenever the resource is updated.
     */
    @JsonProperty(value = "etag", access = JsonProperty.Access.WRITE_ONLY)
    private String etag;

    /*
     * NetApp Account properties
     */
    @JsonProperty(value = "properties")
    private AccountProperties innerProperties;

    /**
     * Get the etag property: A unique read-only string that changes whenever the resource is updated.
     *
     * @return the etag value.
     */
    public String etag() {
        return this.etag;
    }

    /**
     * Get the innerProperties property: NetApp Account properties.
     *
     * @return the innerProperties value.
     */
    private AccountProperties innerProperties() {
        return this.innerProperties;
    }

    /** {@inheritDoc} */
    @Override
    public NetAppAccountInner withLocation(String location) {
        super.withLocation(location);
        return this;
    }

    /** {@inheritDoc} */
    @Override
    public NetAppAccountInner withTags(Map<String, String> tags) {
        super.withTags(tags);
        return this;
    }

    /**
     * Get the provisioningState property: Azure lifecycle management.
     *
     * @return the provisioningState value.
     */
    public String provisioningState() {
        return this.innerProperties() == null ? null : this.innerProperties().provisioningState();
    }

    /**
     * Get the activeDirectories property: Active Directories.
     *
     * @return the activeDirectories value.
     */
    public List<ActiveDirectory> activeDirectories() {
        return this.innerProperties() == null ? null : this.innerProperties().activeDirectories();
    }

    /**
     * Set the activeDirectories property: Active Directories.
     *
     * @param activeDirectories the activeDirectories value to set.
     * @return the NetAppAccountInner object itself.
     */
    public NetAppAccountInner withActiveDirectories(List<ActiveDirectory> activeDirectories) {
        if (this.innerProperties() == null) {
            this.innerProperties = new AccountProperties();
        }
        this.innerProperties().withActiveDirectories(activeDirectories);
        return this;
    }

    /**
     * Get the encryption property: Encryption settings.
     *
     * @return the encryption value.
     */
    public AccountEncryption encryption() {
        return this.innerProperties() == null ? null : this.innerProperties().encryption();
    }

    /**
     * Set the encryption property: Encryption settings.
     *
     * @param encryption the encryption value to set.
     * @return the NetAppAccountInner object itself.
     */
    public NetAppAccountInner withEncryption(AccountEncryption encryption) {
        if (this.innerProperties() == null) {
            this.innerProperties = new AccountProperties();
        }
        this.innerProperties().withEncryption(encryption);
        return this;
    }

    /**
     * Validates the instance.
     *
     * @throws IllegalArgumentException thrown if the instance is not valid.
     */
    public void validate() {
        if (innerProperties() != null) {
            innerProperties().validate();
        }
    }
}
