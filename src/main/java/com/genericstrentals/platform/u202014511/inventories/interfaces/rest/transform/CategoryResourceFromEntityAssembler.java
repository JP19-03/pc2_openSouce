package com.genericstrentals.platform.u202014511.inventories.interfaces.rest.transform;

import com.genericstrentals.platform.u202014511.inventories.domain.model.aggregates.Category;
import com.genericstrentals.platform.u202014511.inventories.interfaces.rest.resources.CategoryResource;

public class CategoryResourceFromEntityAssembler {
    public static CategoryResource toResourceFromEntity(Category entity) {
        return new CategoryResource(
                entity.getId(),
                entity.getName(),
                entity.getGroupId(),
                entity.getDescription(),
                entity.getReferenceImageUrl(),
                entity.getCategoryStatus()
        );
    }
}
