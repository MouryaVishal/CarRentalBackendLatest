package com.example.service;

import com.example.exception.CategoryNotFoundException;
import com.example.model.Category;
import com.example.repo.CategoryRepository;
import com.example.service.servicesInterface.CategoryServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class CategoryService implements CategoryServiceInterface {
    @Autowired
    private CategoryRepository categoryRepository;
    public Category addCategory(Category category){
        return categoryRepository.save(category);
    }

    public Iterable<Category> allCategory(){
        return categoryRepository.findAll();
    }

    public String deleteById(Long id){
        if(categoryRepository.existsById(id)) {
            categoryRepository.deleteById(id);
            return "Deleted SuccessFully!!";
        };
        return "Delete Fail. No Such id found!!";
    }

    public ResponseEntity<Category> updateById(Long id, Category categoryDetails) {
        Optional<Category> optionalCategory = categoryRepository.findById(id);
        if (optionalCategory.isPresent()) {
//            Category category = optionalCategory.get();
//            category.setCategoryName(categoryDetails.getCategoryName());
            Category updatedCat = categoryRepository.save(categoryDetails);
            return new ResponseEntity<Category>(updatedCat, HttpStatus.OK);
        } else {
            throw new CategoryNotFoundException();
        }
    }


}
