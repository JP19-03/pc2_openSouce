package com.genericstrentals.platform.u202014511.inventories.interfaces.rest.transform;

import com.genericstrentals.platform.u202014511.inventories.domain.model.commands.CreateCategoryCommand;
import com.genericstrentals.platform.u202014511.inventories.interfaces.rest.resources.CreateCategoryResource;

/**
 * Assembler class to convert CreateCategoryResource to CreateCategoryCommand
 * @summary
 * This class is used to the incoming request to a command that can be executed by the application
 * @author Johan Principe Godoy u202014511
 * @version 1.0
 */
public class CreateCategoryCommandFromResourceAssembler {

    /**
     * Converts a CreateCategoryResource to a CreateCategoryCommand
     *
     * @param resource The resource to convert
     * @return The converted command
     * @see CreateCategoryResource
     * @see CreateCategoryCommand
     */
    public static CreateCategoryCommand toCommandFromResource(CreateCategoryResource resource) {
        return new CreateCategoryCommand(
                resource.name(),
                resource.groupId(),
                resource.description(),
                resource.referenceImageUrl()
        );
    }
}
