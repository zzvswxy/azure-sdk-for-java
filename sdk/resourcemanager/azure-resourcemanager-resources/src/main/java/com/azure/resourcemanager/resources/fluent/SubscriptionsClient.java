// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.resources.fluent;

import com.azure.core.annotation.ReturnType;
import com.azure.core.annotation.ServiceMethod;
import com.azure.core.http.rest.PagedFlux;
import com.azure.core.http.rest.PagedIterable;
import com.azure.core.http.rest.Response;
import com.azure.core.util.Context;
import com.azure.resourcemanager.resources.fluent.models.CheckZonePeersResultInner;
import com.azure.resourcemanager.resources.fluent.models.LocationInner;
import com.azure.resourcemanager.resources.fluent.models.SubscriptionInner;
import com.azure.resourcemanager.resources.models.CheckZonePeersRequest;
import reactor.core.publisher.Mono;

/** An instance of this class provides access to all the operations defined in SubscriptionsClient. */
public interface SubscriptionsClient {
    /**
     * This operation provides all the locations that are available for resource providers; however, each resource
     * provider may support a subset of this list.
     *
     * @param subscriptionId The ID of the target subscription.
     * @param includeExtendedLocations Whether to include extended locations.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return location list operation response as paginated response with {@link PagedFlux}.
     */
    @ServiceMethod(returns = ReturnType.COLLECTION)
    PagedFlux<LocationInner> listLocationsAsync(String subscriptionId, Boolean includeExtendedLocations);

    /**
     * This operation provides all the locations that are available for resource providers; however, each resource
     * provider may support a subset of this list.
     *
     * @param subscriptionId The ID of the target subscription.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return location list operation response as paginated response with {@link PagedFlux}.
     */
    @ServiceMethod(returns = ReturnType.COLLECTION)
    PagedFlux<LocationInner> listLocationsAsync(String subscriptionId);

    /**
     * This operation provides all the locations that are available for resource providers; however, each resource
     * provider may support a subset of this list.
     *
     * @param subscriptionId The ID of the target subscription.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return location list operation response as paginated response with {@link PagedIterable}.
     */
    @ServiceMethod(returns = ReturnType.COLLECTION)
    PagedIterable<LocationInner> listLocations(String subscriptionId);

    /**
     * This operation provides all the locations that are available for resource providers; however, each resource
     * provider may support a subset of this list.
     *
     * @param subscriptionId The ID of the target subscription.
     * @param includeExtendedLocations Whether to include extended locations.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return location list operation response as paginated response with {@link PagedIterable}.
     */
    @ServiceMethod(returns = ReturnType.COLLECTION)
    PagedIterable<LocationInner> listLocations(
        String subscriptionId, Boolean includeExtendedLocations, Context context);

    /**
     * Gets details about a specified subscription.
     *
     * @param subscriptionId The ID of the target subscription.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return details about a specified subscription along with {@link Response} on successful completion of {@link
     *     Mono}.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    Mono<Response<SubscriptionInner>> getWithResponseAsync(String subscriptionId);

    /**
     * Gets details about a specified subscription.
     *
     * @param subscriptionId The ID of the target subscription.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return details about a specified subscription on successful completion of {@link Mono}.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    Mono<SubscriptionInner> getAsync(String subscriptionId);

    /**
     * Gets details about a specified subscription.
     *
     * @param subscriptionId The ID of the target subscription.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return details about a specified subscription.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    SubscriptionInner get(String subscriptionId);

    /**
     * Gets details about a specified subscription.
     *
     * @param subscriptionId The ID of the target subscription.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return details about a specified subscription along with {@link Response}.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    Response<SubscriptionInner> getWithResponse(String subscriptionId, Context context);

    /**
     * Gets all subscriptions for a tenant.
     *
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return all subscriptions for a tenant as paginated response with {@link PagedFlux}.
     */
    @ServiceMethod(returns = ReturnType.COLLECTION)
    PagedFlux<SubscriptionInner> listAsync();

    /**
     * Gets all subscriptions for a tenant.
     *
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return all subscriptions for a tenant as paginated response with {@link PagedIterable}.
     */
    @ServiceMethod(returns = ReturnType.COLLECTION)
    PagedIterable<SubscriptionInner> list();

    /**
     * Gets all subscriptions for a tenant.
     *
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return all subscriptions for a tenant as paginated response with {@link PagedIterable}.
     */
    @ServiceMethod(returns = ReturnType.COLLECTION)
    PagedIterable<SubscriptionInner> list(Context context);

    /**
     * Compares a subscriptions logical zone mapping.
     *
     * @param subscriptionId The ID of the target subscription.
     * @param parameters Parameters for checking zone peers.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return result of the Check zone peers operation along with {@link Response} on successful completion of {@link
     *     Mono}.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    Mono<Response<CheckZonePeersResultInner>> checkZonePeersWithResponseAsync(
        String subscriptionId, CheckZonePeersRequest parameters);

    /**
     * Compares a subscriptions logical zone mapping.
     *
     * @param subscriptionId The ID of the target subscription.
     * @param parameters Parameters for checking zone peers.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return result of the Check zone peers operation on successful completion of {@link Mono}.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    Mono<CheckZonePeersResultInner> checkZonePeersAsync(String subscriptionId, CheckZonePeersRequest parameters);

    /**
     * Compares a subscriptions logical zone mapping.
     *
     * @param subscriptionId The ID of the target subscription.
     * @param parameters Parameters for checking zone peers.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return result of the Check zone peers operation.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    CheckZonePeersResultInner checkZonePeers(String subscriptionId, CheckZonePeersRequest parameters);

    /**
     * Compares a subscriptions logical zone mapping.
     *
     * @param subscriptionId The ID of the target subscription.
     * @param parameters Parameters for checking zone peers.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return result of the Check zone peers operation along with {@link Response}.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    Response<CheckZonePeersResultInner> checkZonePeersWithResponse(
        String subscriptionId, CheckZonePeersRequest parameters, Context context);
}
