package com.example.repo;

import com.example.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CategoryRepository extends JpaRepository<Category,Long> {

    public Iterable<Category> findByCategoryName(String categoryName);

}
