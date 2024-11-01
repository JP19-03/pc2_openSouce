package com.genericstrentals.platform.u202014511.inventories.domain.services;

import com.genericstrentals.platform.u202014511.inventories.domain.model.aggregates.Category;
import com.genericstrentals.platform.u202014511.inventories.domain.model.commands.CreateCategoryCommand;

import java.util.Optional;

/**
 * Service to handle commands related to categories.
 * @summary
 * This service is responsible for handling commands related to categories.
 * @author Johan Principe Godoy u202014511
 * @version 1.0
 */
public interface CategoryCommandService {

    /**
     * Handles the command to create a category.
     *
     * @param command The command to create a category.
     * @return The created category.
     * @throws IllegalArgumentException If the command is invalid.
     * @see CreateCategoryCommand
     */
    Optional<Category> handle(CreateCategoryCommand command);
}
