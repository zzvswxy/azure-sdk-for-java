// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.storagecache.models;

import com.azure.core.annotation.Fluent;
import com.fasterxml.jackson.annotation.JsonProperty;

/** When present, these are the credentials for the secure LDAP connection. */
@Fluent
public final class CacheUsernameDownloadSettingsCredentials {
    /*
     * The Bind Distinguished Name identity to be used in the secure LDAP
     * connection. This value is stored encrypted and not returned on response.
     */
    @JsonProperty(value = "bindDn")
    private String bindDn;

    /*
     * The Bind password to be used in the secure LDAP connection. This value
     * is stored encrypted and not returned on response.
     */
    @JsonProperty(value = "bindPassword")
    private String bindPassword;

    /**
     * Get the bindDn property: The Bind Distinguished Name identity to be used in the secure LDAP connection. This
     * value is stored encrypted and not returned on response.
     *
     * @return the bindDn value.
     */
    public String bindDn() {
        return this.bindDn;
    }

    /**
     * Set the bindDn property: The Bind Distinguished Name identity to be used in the secure LDAP connection. This
     * value is stored encrypted and not returned on response.
     *
     * @param bindDn the bindDn value to set.
     * @return the CacheUsernameDownloadSettingsCredentials object itself.
     */
    public CacheUsernameDownloadSettingsCredentials withBindDn(String bindDn) {
        this.bindDn = bindDn;
        return this;
    }

    /**
     * Get the bindPassword property: The Bind password to be used in the secure LDAP connection. This value is stored
     * encrypted and not returned on response.
     *
     * @return the bindPassword value.
     */
    public String bindPassword() {
        return this.bindPassword;
    }

    /**
     * Set the bindPassword property: The Bind password to be used in the secure LDAP connection. This value is stored
     * encrypted and not returned on response.
     *
     * @param bindPassword the bindPassword value to set.
     * @return the CacheUsernameDownloadSettingsCredentials object itself.
     */
    public CacheUsernameDownloadSettingsCredentials withBindPassword(String bindPassword) {
        this.bindPassword = bindPassword;
        return this;
    }

    /**
     * Validates the instance.
     *
     * @throws IllegalArgumentException thrown if the instance is not valid.
     */
    public void validate() {
    }
}
