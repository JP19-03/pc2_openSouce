package com.genericstrentals.platform.u202014511.inventories.domain.services;

import com.genericstrentals.platform.u202014511.inventories.domain.model.commands.SeedGroupsCommand;

public interface GroupCommandService {
    void handle(SeedGroupsCommand command);
}
