# Code snippets and samples


## Extensions

- [Create](#extensions_create)
- [Delete](#extensions_delete)
- [Get](#extensions_get)
- [ListByFarmBeats](#extensions_listbyfarmbeats)
- [Update](#extensions_update)

## FarmBeatsExtensions

- [Get](#farmbeatsextensions_get)
- [List](#farmbeatsextensions_list)

## FarmBeatsModels

- [CreateOrUpdate](#farmbeatsmodels_createorupdate)
- [Delete](#farmbeatsmodels_delete)
- [GetByResourceGroup](#farmbeatsmodels_getbyresourcegroup)
- [List](#farmbeatsmodels_list)
- [ListByResourceGroup](#farmbeatsmodels_listbyresourcegroup)
- [Update](#farmbeatsmodels_update)

## Locations

- [CheckNameAvailability](#locations_checknameavailability)

## Operations

- [List](#operations_list)
### Extensions_Create

```java
import com.azure.core.util.Context;

/** Samples for Extensions Create. */
public final class ExtensionsCreateSamples {
    /*
     * x-ms-original-file: specification/agrifood/resource-manager/Microsoft.AgFoodPlatform/preview/2022-04-05/examples/Extensions_Create.json
     */
    /**
     * Sample code: Extensions_Create.
     *
     * @param manager Entry point to AgrifoodManager.
     */
    public static void extensionsCreate(com.azure.resourcemanager.agrifood.AgrifoodManager manager) {
        manager
            .extensions()
            .createWithResponse("provider.extension", "examples-farmbeatsResourceName", "examples-rg", Context.NONE);
    }
}
```

### Extensions_Delete

```java
import com.azure.core.util.Context;

/** Samples for Extensions Delete. */
public final class ExtensionsDeleteSamples {
    /*
     * x-ms-original-file: specification/agrifood/resource-manager/Microsoft.AgFoodPlatform/preview/2022-04-05/examples/Extensions_Delete.json
     */
    /**
     * Sample code: Extensions_Delete.
     *
     * @param manager Entry point to AgrifoodManager.
     */
    public static void extensionsDelete(com.azure.resourcemanager.agrifood.AgrifoodManager manager) {
        manager
            .extensions()
            .deleteWithResponse("provider.extension", "examples-farmbeatsResourceName", "examples-rg", Context.NONE);
    }
}
```

### Extensions_Get

```java
import com.azure.core.util.Context;

/** Samples for Extensions Get. */
public final class ExtensionsGetSamples {
    /*
     * x-ms-original-file: specification/agrifood/resource-manager/Microsoft.AgFoodPlatform/preview/2022-04-05/examples/Extensions_Get.json
     */
    /**
     * Sample code: Extensions_Get.
     *
     * @param manager Entry point to AgrifoodManager.
     */
    public static void extensionsGet(com.azure.resourcemanager.agrifood.AgrifoodManager manager) {
        manager
            .extensions()
            .getWithResponse("provider.extension", "examples-farmbeatsResourceName", "examples-rg", Context.NONE);
    }
}
```

### Extensions_ListByFarmBeats

```java
import com.azure.core.util.Context;

/** Samples for Extensions ListByFarmBeats. */
public final class ExtensionsListByFarmBeatsSamples {
    /*
     * x-ms-original-file: specification/agrifood/resource-manager/Microsoft.AgFoodPlatform/preview/2022-04-05/examples/Extensions_ListByFarmBeats.json
     */
    /**
     * Sample code: Extensions_ListByFarmBeats.
     *
     * @param manager Entry point to AgrifoodManager.
     */
    public static void extensionsListByFarmBeats(com.azure.resourcemanager.agrifood.AgrifoodManager manager) {
        manager
            .extensions()
            .listByFarmBeats("examples-rg", "examples-farmbeatsResourceName", null, null, null, null, Context.NONE);
    }
}
```

### Extensions_Update

```java
import com.azure.core.util.Context;

/** Samples for Extensions Update. */
public final class ExtensionsUpdateSamples {
    /*
     * x-ms-original-file: specification/agrifood/resource-manager/Microsoft.AgFoodPlatform/preview/2022-04-05/examples/Extensions_Update.json
     */
    /**
     * Sample code: Extensions_Update.
     *
     * @param manager Entry point to AgrifoodManager.
     */
    public static void extensionsUpdate(com.azure.resourcemanager.agrifood.AgrifoodManager manager) {
        manager
            .extensions()
            .updateWithResponse("provider.extension", "examples-farmbeatsResourceName", "examples-rg", Context.NONE);
    }
}
```

### FarmBeatsExtensions_Get

```java
import com.azure.core.util.Context;

/** Samples for FarmBeatsExtensions Get. */
public final class FarmBeatsExtensionsGetSamples {
    /*
     * x-ms-original-file: specification/agrifood/resource-manager/Microsoft.AgFoodPlatform/preview/2022-04-05/examples/FarmBeatsExtensions_Get.json
     */
    /**
     * Sample code: FarmBeatsExtensions_Get.
     *
     * @param manager Entry point to AgrifoodManager.
     */
    public static void farmBeatsExtensionsGet(com.azure.resourcemanager.agrifood.AgrifoodManager manager) {
        manager.farmBeatsExtensions().getWithResponse("DTN.ContentServices", Context.NONE);
    }
}
```

### FarmBeatsExtensions_List

```java
import com.azure.core.util.Context;

/** Samples for FarmBeatsExtensions List. */
public final class FarmBeatsExtensionsListSamples {
    /*
     * x-ms-original-file: specification/agrifood/resource-manager/Microsoft.AgFoodPlatform/preview/2022-04-05/examples/FarmBeatsExtensions_List.json
     */
    /**
     * Sample code: FarmBeatsExtensions_List.
     *
     * @param manager Entry point to AgrifoodManager.
     */
    public static void farmBeatsExtensionsList(com.azure.resourcemanager.agrifood.AgrifoodManager manager) {
        manager.farmBeatsExtensions().list(null, null, null, null, null, Context.NONE);
    }
}
```

### FarmBeatsModels_CreateOrUpdate

```java
import java.util.HashMap;
import java.util.Map;

/** Samples for FarmBeatsModels CreateOrUpdate. */
public final class FarmBeatsModelsCreateOrUpdateSamples {
    /*
     * x-ms-original-file: specification/agrifood/resource-manager/Microsoft.AgFoodPlatform/preview/2022-04-05/examples/FarmBeatsModels_CreateOrUpdate.json
     */
    /**
     * Sample code: FarmBeatsModels_CreateOrUpdate.
     *
     * @param manager Entry point to AgrifoodManager.
     */
    public static void farmBeatsModelsCreateOrUpdate(com.azure.resourcemanager.agrifood.AgrifoodManager manager) {
        manager
            .farmBeatsModels()
            .define("examples-farmbeatsResourceName")
            .withRegion("eastus2")
            .withExistingResourceGroup("examples-rg")
            .withTags(mapOf("key1", "value1", "key2", "value2"))
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
```

### FarmBeatsModels_Delete

```java
import com.azure.core.util.Context;

/** Samples for FarmBeatsModels Delete. */
public final class FarmBeatsModelsDeleteSamples {
    /*
     * x-ms-original-file: specification/agrifood/resource-manager/Microsoft.AgFoodPlatform/preview/2022-04-05/examples/FarmBeatsModels_Delete.json
     */
    /**
     * Sample code: FarmBeatsModels_Delete.
     *
     * @param manager Entry point to AgrifoodManager.
     */
    public static void farmBeatsModelsDelete(com.azure.resourcemanager.agrifood.AgrifoodManager manager) {
        manager.farmBeatsModels().deleteWithResponse("examples-rg", "examples-farmBeatsResourceName", Context.NONE);
    }
}
```

### FarmBeatsModels_GetByResourceGroup

```java
import com.azure.core.util.Context;

/** Samples for FarmBeatsModels GetByResourceGroup. */
public final class FarmBeatsModelsGetByResourceGroupSamples {
    /*
     * x-ms-original-file: specification/agrifood/resource-manager/Microsoft.AgFoodPlatform/preview/2022-04-05/examples/FarmBeatsModels_Get.json
     */
    /**
     * Sample code: FarmBeatsModels_Get.
     *
     * @param manager Entry point to AgrifoodManager.
     */
    public static void farmBeatsModelsGet(com.azure.resourcemanager.agrifood.AgrifoodManager manager) {
        manager
            .farmBeatsModels()
            .getByResourceGroupWithResponse("examples-rg", "examples-farmBeatsResourceName", Context.NONE);
    }
}
```

### FarmBeatsModels_List

```java
import com.azure.core.util.Context;

/** Samples for FarmBeatsModels List. */
public final class FarmBeatsModelsListSamples {
    /*
     * x-ms-original-file: specification/agrifood/resource-manager/Microsoft.AgFoodPlatform/preview/2022-04-05/examples/FarmBeatsModels_ListBySubscription.json
     */
    /**
     * Sample code: FarmBeatsModels_ListBySubscription.
     *
     * @param manager Entry point to AgrifoodManager.
     */
    public static void farmBeatsModelsListBySubscription(com.azure.resourcemanager.agrifood.AgrifoodManager manager) {
        manager.farmBeatsModels().list(null, null, Context.NONE);
    }
}
```

### FarmBeatsModels_ListByResourceGroup

```java
import com.azure.core.util.Context;

/** Samples for FarmBeatsModels ListByResourceGroup. */
public final class FarmBeatsModelsListByResourceGroupSamples {
    /*
     * x-ms-original-file: specification/agrifood/resource-manager/Microsoft.AgFoodPlatform/preview/2022-04-05/examples/FarmBeatsModels_ListByResourceGroup.json
     */
    /**
     * Sample code: FarmBeatsModels_ListByResourceGroup.
     *
     * @param manager Entry point to AgrifoodManager.
     */
    public static void farmBeatsModelsListByResourceGroup(com.azure.resourcemanager.agrifood.AgrifoodManager manager) {
        manager.farmBeatsModels().listByResourceGroup("examples-rg", null, null, Context.NONE);
    }
}
```

### FarmBeatsModels_Update

```java
import com.azure.core.util.Context;
import com.azure.resourcemanager.agrifood.models.FarmBeats;
import java.util.HashMap;
import java.util.Map;

/** Samples for FarmBeatsModels Update. */
public final class FarmBeatsModelsUpdateSamples {
    /*
     * x-ms-original-file: specification/agrifood/resource-manager/Microsoft.AgFoodPlatform/preview/2022-04-05/examples/FarmBeatsModels_Update.json
     */
    /**
     * Sample code: FarmBeatsModels_Update.
     *
     * @param manager Entry point to AgrifoodManager.
     */
    public static void farmBeatsModelsUpdate(com.azure.resourcemanager.agrifood.AgrifoodManager manager) {
        FarmBeats resource =
            manager
                .farmBeatsModels()
                .getByResourceGroupWithResponse("examples-rg", "examples-farmBeatsResourceName", Context.NONE)
                .getValue();
        resource.update().withTags(mapOf("key1", "value1", "key2", "value2")).apply();
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
```

### Locations_CheckNameAvailability

```java
import com.azure.core.util.Context;
import com.azure.resourcemanager.agrifood.models.CheckNameAvailabilityRequest;

/** Samples for Locations CheckNameAvailability. */
public final class LocationsCheckNameAvailabilitySamples {
    /*
     * x-ms-original-file: specification/agrifood/resource-manager/Microsoft.AgFoodPlatform/preview/2022-04-05/examples/Locations_CheckNameAvailability_Available.json
     */
    /**
     * Sample code: Locations_CheckNameAvailability_Available.
     *
     * @param manager Entry point to AgrifoodManager.
     */
    public static void locationsCheckNameAvailabilityAvailable(
        com.azure.resourcemanager.agrifood.AgrifoodManager manager) {
        manager
            .locations()
            .checkNameAvailabilityWithResponse(
                new CheckNameAvailabilityRequest()
                    .withName("newaccountname")
                    .withType("Microsoft.AgFoodPlatform/farmBeats"),
                Context.NONE);
    }

    /*
     * x-ms-original-file: specification/agrifood/resource-manager/Microsoft.AgFoodPlatform/preview/2022-04-05/examples/Locations_CheckNameAvailability_AlreadyExists.json
     */
    /**
     * Sample code: Locations_CheckNameAvailability_AlreadyExists.
     *
     * @param manager Entry point to AgrifoodManager.
     */
    public static void locationsCheckNameAvailabilityAlreadyExists(
        com.azure.resourcemanager.agrifood.AgrifoodManager manager) {
        manager
            .locations()
            .checkNameAvailabilityWithResponse(
                new CheckNameAvailabilityRequest()
                    .withName("existingaccountname")
                    .withType("Microsoft.AgFoodPlatform/farmBeats"),
                Context.NONE);
    }
}
```

### Operations_List

```java
import com.azure.core.util.Context;

/** Samples for Operations List. */
public final class OperationsListSamples {
    /*
     * x-ms-original-file: specification/agrifood/resource-manager/Microsoft.AgFoodPlatform/preview/2022-04-05/examples/Operations_List.json
     */
    /**
     * Sample code: Operations_List.
     *
     * @param manager Entry point to AgrifoodManager.
     */
    public static void operationsList(com.azure.resourcemanager.agrifood.AgrifoodManager manager) {
        manager.operations().list(Context.NONE);
    }
}
```

