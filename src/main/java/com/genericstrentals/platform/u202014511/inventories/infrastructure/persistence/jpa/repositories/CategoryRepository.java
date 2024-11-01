package com.genericstrentals.platform.u202014511.inventories.infrastructure.persistence.jpa.repositories;

import com.genericstrentals.platform.u202014511.inventories.domain.model.aggregates.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
    boolean existsByName(String name);
}
