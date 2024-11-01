package com.genericstrentals.platform.u202014511.inventories.infrastructure.persistence.jpa.repositories;

import com.genericstrentals.platform.u202014511.inventories.domain.model.entities.Group;
import com.genericstrentals.platform.u202014511.inventories.domain.model.valueobjects.Groups;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * The group repository.
 * @summary
 * This interface is a Spring Data JPA repository that provides methods for accessing the group data in the database.
 * @author Johan Principe Godoy
 * @version 1.0
 */
@Repository
public interface GroupRepository extends JpaRepository<Group, Long> {

    /**
     * Check if a group exists by name.
     *
     * @param name The name of the group.
     * @return True if the group exists, false otherwise.
     */
    boolean existsByName(Groups name);
}
