package com.example.service.servicesInterface;

import com.example.model.Category;

public interface CategoryServiceInterface {
    public Category addCategory(Category category);
    public Iterable<Category> allCategory();
}
