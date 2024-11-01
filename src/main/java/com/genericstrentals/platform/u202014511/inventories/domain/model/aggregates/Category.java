package com.genericstrentals.platform.u202014511.inventories.domain.model.aggregates;

import com.genericstrentals.platform.u202014511.inventories.domain.model.commands.CreateCategoryCommand;
import com.genericstrentals.platform.u202014511.inventories.domain.model.entities.Group;
import com.genericstrentals.platform.u202014511.inventories.domain.model.valueobjects.CategoryStatus;
import com.genericstrentals.platform.u202014511.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;

/**
 * Category
 * @summary
 * This class represents the Category aggregate root.
 * It contains the attributes of a category and the relationships with other entities.
 * @author Johan Principe Godoy u202014511
 * @version 1.0
 */
@Getter
@Entity
public class Category extends AuditableAbstractAggregateRoot<Category> {

    @NotBlank
    @Size(max = 55)
    @Column(unique = true, nullable = false)
    private String name;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "group_id", nullable = false)
    private Group groupId;

    @NotBlank
    @Size(max = 250)
    private String description;

    @NotNull
    private String referenceImageUrl;

    @NotNull
    private String categoryStatus;

    protected Category() {}

    /**
     * Create a new Category
     * @param command The command to create a new category
     * @param group The group to which the category belongs
     * @see CreateCategoryCommand
     * @since 1.0
     */
    public Category(CreateCategoryCommand command, Group group) {
        this.name = command.name();
        this.groupId = group;
        this.description = command.description();
        this.referenceImageUrl = command.referenceImageUrl();
        this.categoryStatus = CategoryStatus.ACTIVE.name();
    }

    public Long getGroupId() {
        return groupId.getId();
    }
}
