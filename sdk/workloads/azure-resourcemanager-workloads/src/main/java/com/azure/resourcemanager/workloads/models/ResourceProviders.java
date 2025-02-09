// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.workloads.models;

import com.azure.core.http.rest.Response;
import com.azure.core.util.Context;

/** Resource collection API of ResourceProviders. */
public interface ResourceProviders {
    /**
     * Get SAP sizing recommendations.
     *
     * @param location The name of Azure region.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return sAP sizing recommendations.
     */
    SapSizingRecommendationResult sapSizingRecommendations(String location);

    /**
     * Get SAP sizing recommendations.
     *
     * @param location The name of Azure region.
     * @param sapSizingRecommendation SAP Sizing Recommendation Request body.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return sAP sizing recommendations along with {@link Response}.
     */
    Response<SapSizingRecommendationResult> sapSizingRecommendationsWithResponse(
        String location, SapSizingRecommendationRequest sapSizingRecommendation, Context context);

    /**
     * Get SAP supported SKUs.
     *
     * @param location The name of Azure region.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return sAP supported SKUs.
     */
    SapSupportedResourceSkusResult sapSupportedSku(String location);

    /**
     * Get SAP supported SKUs.
     *
     * @param location The name of Azure region.
     * @param sapSupportedSku SAP Supported SKU Request body.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return sAP supported SKUs along with {@link Response}.
     */
    Response<SapSupportedResourceSkusResult> sapSupportedSkuWithResponse(
        String location, SapSupportedSkusRequest sapSupportedSku, Context context);

    /**
     * Get SAP Disk Configurations.
     *
     * @param location The name of Azure region.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return sAP Disk Configurations.
     */
    SapDiskConfigurationsResult sapDiskConfigurations(String location);

    /**
     * Get SAP Disk Configurations.
     *
     * @param location The name of Azure region.
     * @param sapDiskConfigurations SAP Disk Configurations Request body.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return sAP Disk Configurations along with {@link Response}.
     */
    Response<SapDiskConfigurationsResult> sapDiskConfigurationsWithResponse(
        String location, SapDiskConfigurationsRequest sapDiskConfigurations, Context context);

    /**
     * Get SAP Availability Zone Details.
     *
     * @param location The name of Azure region.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return sAP Availability Zone Details.
     */
    SapAvailabilityZoneDetailsResult sapAvailabilityZoneDetails(String location);

    /**
     * Get SAP Availability Zone Details.
     *
     * @param location The name of Azure region.
     * @param sapAvailabilityZoneDetails SAP Availability Zone Details Request body.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return sAP Availability Zone Details along with {@link Response}.
     */
    Response<SapAvailabilityZoneDetailsResult> sapAvailabilityZoneDetailsWithResponse(
        String location, SapAvailabilityZoneDetailsRequest sapAvailabilityZoneDetails, Context context);
}
