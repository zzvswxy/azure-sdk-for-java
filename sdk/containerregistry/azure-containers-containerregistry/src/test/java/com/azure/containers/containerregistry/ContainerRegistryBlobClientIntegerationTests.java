// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
package com.azure.containers.containerregistry;

import com.azure.containers.containerregistry.models.OciAnnotations;
import com.azure.containers.containerregistry.models.OciBlobDescriptor;
import com.azure.containers.containerregistry.models.OciManifest;
import com.azure.containers.containerregistry.specialized.ContainerRegistryBlobAsyncClient;
import com.azure.core.http.HttpClient;
import com.azure.core.util.BinaryData;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import static com.azure.containers.containerregistry.TestUtils.DISPLAY_NAME_WITH_ARGUMENTS;

public class ContainerRegistryBlobClientIntegerationTests extends ContainerRegistryClientsTestBase {
    private ContainerRegistryBlobAsyncClient asyncClient;

    private ContainerRegistryBlobAsyncClient getBlobClientAsync(String repositoryName, HttpClient httpClient) {
        return getBlobClientBuilder(repositoryName, httpClient).buildAsyncClient();
    }

    private static OciManifest createManifest() {
        OciManifest manifest = new OciManifest()
            .setSchemaVersion(2)
            .setConfig(new OciBlobDescriptor()
                .setMediaType("application/vnd.acme.rocket.config")
                .setDigest("sha256:d25b42d3dbad5361ed2d909624d899e7254a822c9a632b582ebd3a44f9b0dbc8")
                .setSize(171L));


        List<OciBlobDescriptor> layers = new ArrayList<>();

        layers.add(new OciBlobDescriptor()
            .setMediaType("application/vnd.oci.image.layer.v1.tar")
            .setSize(28L)
            .setDigest("sha256:654b93f61054e4ce90ed203bb8d556a6200d5f906cf3eca0620738d6dc18cbed")
            .setAnnotations(new OciAnnotations()
                .setName("artifact.txt")));

        manifest.setLayers(layers);

        return manifest;
    }

    private void uploadManifestPrerequisites() {
        String layer = "654b93f61054e4ce90ed203bb8d556a6200d5f906cf3eca0620738d6dc18cbed";
        String config = "config.json";
        Path configPath = Paths.get("src", "test", "resources", "oci-artifact", config);
        Path layerPath = Paths.get("src", "test", "resources", "oci-artifact", layer);

        asyncClient.uploadBlob(BinaryData.fromFile(configPath)).block();
        asyncClient.uploadBlob(BinaryData.fromFile(layerPath)).block();
    }

    @ParameterizedTest(name = DISPLAY_NAME_WITH_ARGUMENTS)
    @MethodSource("getHttpClients")
    public void uploadManifest(HttpClient httpClient) {
        asyncClient = getBlobClientAsync("oci-artifact", httpClient);
        uploadManifestPrerequisites();
        OciManifest manifest = createManifest();

        Mono<Void> validateUpload = asyncClient.uploadManifest(manifest)
            .flatMap(uploadManifestResult -> {
                if (uploadManifestResult == null || uploadManifestResult.getDigest() == null) {
                    return Mono.error(new NullPointerException("digest is null"));
                }

                return Mono.just(uploadManifestResult.getDigest());
            }).flatMap(digest -> asyncClient.deleteManifest(digest));

        StepVerifier.create(validateUpload)
            .verifyComplete();
    }
}
