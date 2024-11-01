package com.genericstrentals.platform.u202014511.inventories.interfaces.rest.resources;

/**
 * Resource class for creating a category.
 * @summary
 * It contains the name, groupId, description, and referenceImageUrl of the category.
 * @author Johan Principe Godoy u202014511
 * @version 1.0
 */
public record CreateCategoryResource(
        String name,
        Long groupId,
        String description,
        String referenceImageUrl
) {
}
