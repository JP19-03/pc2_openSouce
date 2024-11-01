package com.genericstrentals.platform.u202014511.inventories.interfaces.rest.resources;

/**
 * CategoryResource resource
 * @summary
 * This class represents the CategoryResource resource. It is used to expose the category information to the client.
 * @author Johan Principe Godoy u202014511
 * @version 1.0
 */
public record CategoryResource(
        Long id,
        String name,
        Long groupId,
        String description,
        String referenceImageUrl,
        String categoryStatus
) {
}
