package com.example.productcatalogdemo.services;

import com.example.productcatalogdemo.dtos.CategoryDTO;
import com.example.productcatalogdemo.models.Category;

import java.util.List;
import java.util.NoSuchElementException;

public interface CategoryService {

    List<Category> getAllCategories();
    Category getCategoryById(Long categoryId) throws NoSuchElementException;
    Category createCategory(CategoryDTO category);
    Category updateCategory(Long categoryId,CategoryDTO category) throws NoSuchElementException;
    void deleteCategory(Long categoryId) throws NoSuchElementException;
}
