package com.genericstrentals.platform.u202014511.inventories.domain.model.commands;

public record CreateCategoryCommand(
        String name,
        Long groupId,
        String description,
        String referenceImageUrl
) {
}
