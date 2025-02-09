// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.machinelearning.generated;

import com.azure.resourcemanager.machinelearning.models.ModelContainerDetails;
import java.util.HashMap;
import java.util.Map;

/** Samples for ModelContainers CreateOrUpdate. */
public final class ModelContainersCreateOrUpdateSamples {
    /*
     * x-ms-original-file: specification/machinelearningservices/resource-manager/Microsoft.MachineLearningServices/preview/2022-02-01-preview/examples/ModelContainer/createOrUpdate.json
     */
    /**
     * Sample code: CreateOrUpdate Model Container.
     *
     * @param manager Entry point to MachineLearningManager.
     */
    public static void createOrUpdateModelContainer(
        com.azure.resourcemanager.machinelearning.MachineLearningManager manager) {
        manager
            .modelContainers()
            .define("testContainer")
            .withExistingWorkspace("testrg123", "workspace123")
            .withProperties(
                new ModelContainerDetails()
                    .withDescription("Model container description")
                    .withTags(mapOf("tag1", "value1", "tag2", "value2")))
            .create();
    }

    @SuppressWarnings("unchecked")
    private static <T> Map<String, T> mapOf(Object... inputs) {
        Map<String, T> map = new HashMap<>();
        for (int i = 0; i < inputs.length; i += 2) {
            String key = (String) inputs[i];
            T value = (T) inputs[i + 1];
            map.put(key, value);
        }
        return map;
    }
}
