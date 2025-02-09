// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.mediaservices.models;

import com.azure.core.annotation.Fluent;
import com.azure.core.util.CoreUtils;
import com.azure.core.util.logging.ClientLogger;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeName;

/** Specifies a RSA key for token validation. */
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "@odata.type")
@JsonTypeName("#Microsoft.Media.ContentKeyPolicyRsaTokenKey")
@Fluent
public final class ContentKeyPolicyRsaTokenKey extends ContentKeyPolicyRestrictionTokenKey {
    /*
     * The RSA Parameter exponent
     */
    @JsonProperty(value = "exponent", required = true)
    private byte[] exponent;

    /*
     * The RSA Parameter modulus
     */
    @JsonProperty(value = "modulus", required = true)
    private byte[] modulus;

    /**
     * Get the exponent property: The RSA Parameter exponent.
     *
     * @return the exponent value.
     */
    public byte[] exponent() {
        return CoreUtils.clone(this.exponent);
    }

    /**
     * Set the exponent property: The RSA Parameter exponent.
     *
     * @param exponent the exponent value to set.
     * @return the ContentKeyPolicyRsaTokenKey object itself.
     */
    public ContentKeyPolicyRsaTokenKey withExponent(byte[] exponent) {
        this.exponent = CoreUtils.clone(exponent);
        return this;
    }

    /**
     * Get the modulus property: The RSA Parameter modulus.
     *
     * @return the modulus value.
     */
    public byte[] modulus() {
        return CoreUtils.clone(this.modulus);
    }

    /**
     * Set the modulus property: The RSA Parameter modulus.
     *
     * @param modulus the modulus value to set.
     * @return the ContentKeyPolicyRsaTokenKey object itself.
     */
    public ContentKeyPolicyRsaTokenKey withModulus(byte[] modulus) {
        this.modulus = CoreUtils.clone(modulus);
        return this;
    }

    /**
     * Validates the instance.
     *
     * @throws IllegalArgumentException thrown if the instance is not valid.
     */
    @Override
    public void validate() {
        super.validate();
        if (exponent() == null) {
            throw LOGGER
                .logExceptionAsError(
                    new IllegalArgumentException(
                        "Missing required property exponent in model ContentKeyPolicyRsaTokenKey"));
        }
        if (modulus() == null) {
            throw LOGGER
                .logExceptionAsError(
                    new IllegalArgumentException(
                        "Missing required property modulus in model ContentKeyPolicyRsaTokenKey"));
        }
    }

    private static final ClientLogger LOGGER = new ClientLogger(ContentKeyPolicyRsaTokenKey.class);
}
