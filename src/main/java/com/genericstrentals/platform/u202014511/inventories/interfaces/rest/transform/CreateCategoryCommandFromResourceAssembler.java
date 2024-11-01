package com.genericstrentals.platform.u202014511.inventories.interfaces.rest.transform;

import com.genericstrentals.platform.u202014511.inventories.domain.model.commands.CreateCategoryCommand;
import com.genericstrentals.platform.u202014511.inventories.interfaces.rest.resources.CreateCategoryResource;

public class CreateCategoryCommandFromResourceAssembler {
    public static CreateCategoryCommand toCommandFromResource(CreateCategoryResource resource) {
        return new CreateCategoryCommand(
                resource.name(),
                resource.groupId(),
                resource.description(),
                resource.referenceImageUrl()
        );
    }
}
