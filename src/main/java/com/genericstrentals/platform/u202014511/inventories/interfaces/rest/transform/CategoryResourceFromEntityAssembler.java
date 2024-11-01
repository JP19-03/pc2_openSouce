package com.genericstrentals.platform.u202014511.inventories.interfaces.rest.transform;

import com.genericstrentals.platform.u202014511.inventories.domain.model.aggregates.Category;
import com.genericstrentals.platform.u202014511.inventories.interfaces.rest.resources.CategoryResource;

public class CategoryResourceFromEntityAssembler {

    /**
     * Converts a Category entity to a CategoryResource
     *
     * @param entity Category entity
     * @return The CategoryResource
     * @see Category
     * @see CategoryResource
     */
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
