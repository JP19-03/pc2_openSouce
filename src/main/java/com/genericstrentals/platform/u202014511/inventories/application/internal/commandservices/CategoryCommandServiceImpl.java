package com.genericstrentals.platform.u202014511.inventories.application.internal.commandservices;

import com.genericstrentals.platform.u202014511.inventories.domain.exceptions.GroupNotFoundException;
import com.genericstrentals.platform.u202014511.inventories.domain.model.aggregates.Category;
import com.genericstrentals.platform.u202014511.inventories.domain.model.commands.CreateCategoryCommand;
import com.genericstrentals.platform.u202014511.inventories.domain.model.entities.Group;
import com.genericstrentals.platform.u202014511.inventories.domain.services.CategoryCommandService;
import com.genericstrentals.platform.u202014511.inventories.infrastructure.persistence.jpa.repositories.CategoryRepository;
import com.genericstrentals.platform.u202014511.inventories.infrastructure.persistence.jpa.repositories.GroupRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Implementation of the CategoryCommandService interface
 * @summary
 * This class is responsible for handling the CreateCategoryCommand command
 * @author Johan Principe Godoy u202014511
 * @version 1.0
 */
@Service
public class CategoryCommandServiceImpl implements CategoryCommandService {
    private final CategoryRepository categoryRepository;
    private final GroupRepository groupRepository;

    public CategoryCommandServiceImpl(CategoryRepository categoryRepository, GroupRepository groupRepository) {
        this.categoryRepository = categoryRepository;
        this.groupRepository = groupRepository;
    }

    /** inheritedDoc */
    @Override
    public Optional<Category> handle(CreateCategoryCommand command) {
        if (categoryRepository.existsByName(command.name())) {
            throw new IllegalArgumentException("Category with name " + command.name() + " already exists");
        }
        Group group = this.groupRepository.findById(command.groupId())
                .orElseThrow(() -> new GroupNotFoundException(command.groupId()));

        Category category = new Category(command, group);
        var categorySaved = categoryRepository.save(category);
        return Optional.of(categorySaved);
    }
}
