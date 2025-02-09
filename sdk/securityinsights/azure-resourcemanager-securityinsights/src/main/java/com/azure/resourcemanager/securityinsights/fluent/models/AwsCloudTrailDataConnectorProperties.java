// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.securityinsights.fluent.models;

import com.azure.core.annotation.Fluent;
import com.azure.core.util.logging.ClientLogger;
import com.azure.resourcemanager.securityinsights.models.AwsCloudTrailDataConnectorDataTypes;
import com.fasterxml.jackson.annotation.JsonProperty;

/** Amazon Web Services CloudTrail data connector properties. */
@Fluent
public final class AwsCloudTrailDataConnectorProperties {
    /*
     * The Aws Role Arn (with CloudTrailReadOnly policy) that is used to access
     * the Aws account.
     */
    @JsonProperty(value = "awsRoleArn")
    private String awsRoleArn;

    /*
     * The available data types for the connector.
     */
    @JsonProperty(value = "dataTypes", required = true)
    private AwsCloudTrailDataConnectorDataTypes dataTypes;

    /**
     * Get the awsRoleArn property: The Aws Role Arn (with CloudTrailReadOnly policy) that is used to access the Aws
     * account.
     *
     * @return the awsRoleArn value.
     */
    public String awsRoleArn() {
        return this.awsRoleArn;
    }

    /**
     * Set the awsRoleArn property: The Aws Role Arn (with CloudTrailReadOnly policy) that is used to access the Aws
     * account.
     *
     * @param awsRoleArn the awsRoleArn value to set.
     * @return the AwsCloudTrailDataConnectorProperties object itself.
     */
    public AwsCloudTrailDataConnectorProperties withAwsRoleArn(String awsRoleArn) {
        this.awsRoleArn = awsRoleArn;
        return this;
    }

    /**
     * Get the dataTypes property: The available data types for the connector.
     *
     * @return the dataTypes value.
     */
    public AwsCloudTrailDataConnectorDataTypes dataTypes() {
        return this.dataTypes;
    }

    /**
     * Set the dataTypes property: The available data types for the connector.
     *
     * @param dataTypes the dataTypes value to set.
     * @return the AwsCloudTrailDataConnectorProperties object itself.
     */
    public AwsCloudTrailDataConnectorProperties withDataTypes(AwsCloudTrailDataConnectorDataTypes dataTypes) {
        this.dataTypes = dataTypes;
        return this;
    }

    /**
     * Validates the instance.
     *
     * @throws IllegalArgumentException thrown if the instance is not valid.
     */
    public void validate() {
        if (dataTypes() == null) {
            throw LOGGER
                .logExceptionAsError(
                    new IllegalArgumentException(
                        "Missing required property dataTypes in model AwsCloudTrailDataConnectorProperties"));
        } else {
            dataTypes().validate();
        }
    }

    private static final ClientLogger LOGGER = new ClientLogger(AwsCloudTrailDataConnectorProperties.class);
}
