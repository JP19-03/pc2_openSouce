package com.genericstrentals.platform.u202014511.inventories.infrastructure.persistence.jpa.repositories;

import com.genericstrentals.platform.u202014511.inventories.domain.model.aggregates.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * The category repository.
 * @summary
 * This interface is a Spring Data JPA repository that provides methods for accessing the category data in the database.
 * @author Johan Principe Godoy u202014511
 * @version 1.0
 */
@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

    /**
     * Check if a category exists by name.
     *
     * @param name The name of the category.
     * @return True if the category exists, false otherwise.
     */
    boolean existsByName(String name);
}
