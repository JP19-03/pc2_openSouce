package com.genericstrentals.platform.u202014511.inventories.domain.services;

import com.genericstrentals.platform.u202014511.inventories.domain.model.commands.SeedGroupsCommand;

/**
 * Service to handle commands related to groups.
 * @summary
 * This service is responsible for handling commands related to groups.
 * @author Johan Principe Godoy
 * @version 1.0
 */
public interface GroupCommandService {

    /**
     * Handles the command to seed groups.
     *
     * @param command The command to seed groups.
     * @see SeedGroupsCommand
     * @throws IllegalArgumentException If the command is invalid.
     * @see SeedGroupsCommand
     */
    void handle(SeedGroupsCommand command);
}
