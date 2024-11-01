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
