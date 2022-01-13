// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.

package com.azure.containers.containerregistry.specialized;

import com.azure.containers.containerregistry.ContainerRegistryAsyncClient;
import com.azure.containers.containerregistry.implementation.AzureContainerRegistryImpl;
import com.azure.containers.containerregistry.implementation.AzureContainerRegistryImplBuilder;
import com.azure.containers.containerregistry.implementation.ContainerRegistriesImpl;
import com.azure.containers.containerregistry.implementation.ContainerRegistryBlobsImpl;
import com.azure.containers.containerregistry.implementation.models.ContainerRegistriesCreateManifestResponse;
import com.azure.core.annotation.ReturnType;
import com.azure.core.annotation.ServiceClient;
import com.azure.core.annotation.ServiceMethod;
import com.azure.core.http.HttpPipeline;

import com.azure.core.util.FluxUtil;
import com.azure.core.util.logging.ClientLogger;
import reactor.core.publisher.Mono;

import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

import static com.azure.core.util.FluxUtil.withContext;

@ServiceClient(builder = ContainerRegistryBlobClientBuilder.class, isAsync = true)
public class ContainerRegistryBlobAsyncClient {

    private final AzureContainerRegistryImpl registryImplClient;
    private final ContainerRegistryBlobsImpl blobsImpl;
    private final ContainerRegistriesImpl registriesImpl;
    private final HttpPipeline httpPipeline;
    private final String endpoint;
    private final String apiVersion;
    private final String repositoryName;
    private final String registryLoginServer;

    private final ClientLogger logger = new ClientLogger(ContainerRegistryAsyncClient.class);

    ContainerRegistryBlobAsyncClient(String repositoryName, HttpPipeline httpPipeline, String endpoint, String version) {
        this.repositoryName = repositoryName;
        this.httpPipeline = httpPipeline;
        this.endpoint = endpoint;
        this.registryImplClient = new AzureContainerRegistryImplBuilder()
            .url(endpoint)
            .pipeline(httpPipeline)
            //.apiVersion(version)
            .buildClient();
        this.blobsImpl = this.registryImplClient.getContainerRegistryBlobs();
        this.registriesImpl = this.registryImplClient.getContainerRegistries();
        this.apiVersion = version;
        try {
            URL endpointUrl = new URL(endpoint);
            this.registryLoginServer = endpointUrl.getHost();
        } catch (MalformedURLException ex) {
            // This will not happen.
            throw logger.logExceptionAsWarning(new IllegalArgumentException("'endpoint' must be a valid URL"));
        }
    }

    @ServiceMethod(returns = ReturnType.COLLECTION)
    public Mono<ContainerRegistriesCreateManifestResponse> uploadManifest(
        InputStream manifestStream,
        int length,
        String digest) {
        return withContext(context -> this.registriesImpl.createManifestWithResponseAsync(
            repositoryName,
            digest,
            FluxUtil.toFluxByteBuffer(manifestStream, length),
            length,
            "application/vnd.oci.image.manifest.v1+json",
            context));
    }
}
