package com.tobeto.pair7Demo.repositories;

import com.tobeto.pair7Demo.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category,Integer> {
}
