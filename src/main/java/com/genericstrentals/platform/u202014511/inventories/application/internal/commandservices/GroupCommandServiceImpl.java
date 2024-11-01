package com.genericstrentals.platform.u202014511.inventories.application.internal.commandservices;

import com.genericstrentals.platform.u202014511.inventories.domain.model.commands.SeedGroupsCommand;
import com.genericstrentals.platform.u202014511.inventories.domain.model.entities.Group;
import com.genericstrentals.platform.u202014511.inventories.domain.model.valueobjects.Groups;
import com.genericstrentals.platform.u202014511.inventories.domain.services.GroupCommandService;
import com.genericstrentals.platform.u202014511.inventories.infrastructure.persistence.jpa.repositories.GroupRepository;
import org.springframework.stereotype.Service;

import javax.management.relation.Role;
import java.util.Arrays;

/**
 * Implementation of the GroupCommandService interface
 * @summary
 * This class is responsible for handling the SeedGroupsCommand command
 * @author Johan Principe Godoy
 * @version 1.0
 */
@Service
public class GroupCommandServiceImpl implements GroupCommandService {
    private final GroupRepository groupRepository;

    public GroupCommandServiceImpl(GroupRepository groupRepository) {
        this.groupRepository = groupRepository;
    }

    /** inheritedDoc */
    @Override
    public void handle(SeedGroupsCommand command) {
        Arrays.stream(Groups.values()).forEach(group -> {
            if (!groupRepository.existsByName(group)) {
                groupRepository.save(new Group(Groups.valueOf(group.name())));
            }
        });
    }
}
