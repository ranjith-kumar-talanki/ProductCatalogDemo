package com.example.productcatalogdemo.services;

import com.example.productcatalogdemo.dtos.CategoryDTO;
import com.example.productcatalogdemo.models.Category;
import com.example.productcatalogdemo.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@Primary
public class StoreCategoryService implements CategoryService {

    private final CategoryRepository categoryRepository;

    @Autowired
    public StoreCategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    @Override
    public Category getCategoryById(Long categoryId) throws NoSuchElementException {
        return categoryRepository.findById(categoryId).orElseThrow(() -> new NoSuchElementException("No Category found with id: " + categoryId));
    }

    @Override
    public Category createCategory(CategoryDTO category) {
        Category newCategory = new Category();
        newCategory.setName(category.getName());
        newCategory.setDescription(category.getDescription());
        newCategory.setImageUrl(category.getImageUrl());
        categoryRepository.save(newCategory);
        return newCategory;
    }

    @Override
    public Category updateCategory(Long categoryId, CategoryDTO category) throws NoSuchElementException {
        Category updateCategory = categoryRepository.findById(categoryId).orElseThrow(() -> new NoSuchElementException("No Category found with id: " + categoryId));
        if (category.getName() != null) updateCategory.setName(category.getName());
        updateCategory.setDescription(category.getDescription());
        updateCategory.setImageUrl(category.getImageUrl());
        categoryRepository.save(updateCategory);
        return updateCategory;
    }

    @Override
    public void deleteCategory(Long categoryId) throws NoSuchElementException {
        Category deleteCategory = categoryRepository.findById(categoryId).orElseThrow(() -> new NoSuchElementException("No Category found with id: " + categoryId));
        deleteCategory.setMarkForDelete(1);
        categoryRepository.save(deleteCategory);
    }
}
