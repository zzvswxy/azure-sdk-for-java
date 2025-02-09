// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.machinelearning.models;

import com.azure.core.annotation.Fluent;
import com.fasterxml.jackson.annotation.JsonProperty;

/** HDInsight compute properties. */
@Fluent
public final class HDInsightProperties {
    /*
     * Port open for ssh connections on the master node of the cluster.
     */
    @JsonProperty(value = "sshPort")
    private Integer sshPort;

    /*
     * Public IP address of the master node of the cluster.
     */
    @JsonProperty(value = "address")
    private String address;

    /*
     * Admin credentials for master node of the cluster
     */
    @JsonProperty(value = "administratorAccount")
    private VirtualMachineSshCredentials administratorAccount;

    /**
     * Get the sshPort property: Port open for ssh connections on the master node of the cluster.
     *
     * @return the sshPort value.
     */
    public Integer sshPort() {
        return this.sshPort;
    }

    /**
     * Set the sshPort property: Port open for ssh connections on the master node of the cluster.
     *
     * @param sshPort the sshPort value to set.
     * @return the HDInsightProperties object itself.
     */
    public HDInsightProperties withSshPort(Integer sshPort) {
        this.sshPort = sshPort;
        return this;
    }

    /**
     * Get the address property: Public IP address of the master node of the cluster.
     *
     * @return the address value.
     */
    public String address() {
        return this.address;
    }

    /**
     * Set the address property: Public IP address of the master node of the cluster.
     *
     * @param address the address value to set.
     * @return the HDInsightProperties object itself.
     */
    public HDInsightProperties withAddress(String address) {
        this.address = address;
        return this;
    }

    /**
     * Get the administratorAccount property: Admin credentials for master node of the cluster.
     *
     * @return the administratorAccount value.
     */
    public VirtualMachineSshCredentials administratorAccount() {
        return this.administratorAccount;
    }

    /**
     * Set the administratorAccount property: Admin credentials for master node of the cluster.
     *
     * @param administratorAccount the administratorAccount value to set.
     * @return the HDInsightProperties object itself.
     */
    public HDInsightProperties withAdministratorAccount(VirtualMachineSshCredentials administratorAccount) {
        this.administratorAccount = administratorAccount;
        return this;
    }

    /**
     * Validates the instance.
     *
     * @throws IllegalArgumentException thrown if the instance is not valid.
     */
    public void validate() {
        if (administratorAccount() != null) {
            administratorAccount().validate();
        }
    }
}
