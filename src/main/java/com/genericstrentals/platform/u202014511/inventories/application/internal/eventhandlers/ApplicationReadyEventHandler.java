package com.genericstrentals.platform.u202014511.inventories.application.internal.eventhandlers;

import com.genericstrentals.platform.u202014511.inventories.domain.model.commands.SeedGroupsCommand;
import com.genericstrentals.platform.u202014511.inventories.domain.services.GroupCommandService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;

@Service
public class ApplicationReadyEventHandler {
    private final GroupCommandService groupCommandService;
    private static final Logger LOGGER = LoggerFactory.getLogger(ApplicationReadyEventHandler.class);

    public ApplicationReadyEventHandler(GroupCommandService groupCommandService) {
        this.groupCommandService = groupCommandService;
    }

    @EventListener
    public void on(ApplicationReadyEvent event) {
        var applicationName = event.getApplicationContext().getId();
        LOGGER.info("Application {} is ready at {}", applicationName, currentTimestamp());
        var seedGroupsCommand = new SeedGroupsCommand();
        groupCommandService.handle(seedGroupsCommand);
        LOGGER.info("Seed groups command handled at {}", currentTimestamp());
    }

    private Timestamp currentTimestamp() {
        return new Timestamp(System.currentTimeMillis());
    }
}
