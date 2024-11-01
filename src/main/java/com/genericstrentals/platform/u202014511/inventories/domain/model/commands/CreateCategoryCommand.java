package com.genericstrentals.platform.u202014511.inventories.domain.model.commands;

/**
 * Command to create a category
 * @summary
 * This command is used to create a category
 * It requires the name of the category, the group id, the description and the reference image url
 */
public record CreateCategoryCommand(
        String name,
        Long groupId,
        String description,
        String referenceImageUrl
) {
}
