package com.example.productcatalogdemo.controllers;

import com.example.productcatalogdemo.dtos.CategoryDTO;
import com.example.productcatalogdemo.models.Category;
import com.example.productcatalogdemo.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {

    private final CategoryService categoryService;

    @Autowired
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }


    @GetMapping("allCategories")
    public ResponseEntity<List<CategoryDTO>> getAllCategories() {
        List<Category> categories = categoryService.getAllCategories();
        if (categories != null && !categories.isEmpty()) {
            List<CategoryDTO> categoriesDTO = categories.stream().map(this::convertToCategoryDTO).toList();
            return new ResponseEntity<>(categoriesDTO, HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("activeCategories")
    public ResponseEntity<List<CategoryDTO>> getAllActiveCategories() {
        List<Category> activeCategories = categoryService.fetchAllActiveCategories();
        if (activeCategories == null || activeCategories.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        List<CategoryDTO> activeCategoriesDTO = activeCategories.stream().map(this::convertToCategoryDTO).toList();
        return new ResponseEntity<>(activeCategoriesDTO, HttpStatus.OK);
    }

    @GetMapping("{categoryId}")
    public ResponseEntity<CategoryDTO> getCategoryById(@PathVariable Long categoryId) {
        Category category = categoryService.getCategoryById(categoryId);

        return new ResponseEntity<>(this.convertToCategoryDTO(category), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<CategoryDTO> createCategory(@RequestBody CategoryDTO categoryDTO) {
        Category category = categoryService.createCategory(categoryDTO);
        return new ResponseEntity<>(this.convertToCategoryDTO(category), HttpStatus.OK);
    }

    @PutMapping("{categoryId}")
    public ResponseEntity<CategoryDTO> updateCategory(@PathVariable Long categoryId, @RequestBody CategoryDTO categoryDTO) {
        Category category = categoryService.updateCategory(categoryId, categoryDTO);
        return new ResponseEntity<>(this.convertToCategoryDTO(category), HttpStatus.OK);
    }

    @DeleteMapping("{categoryId}")
    public ResponseEntity<CategoryDTO> deleteCategory(@PathVariable Long categoryId) {
        categoryService.deleteCategory(categoryId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    private CategoryDTO convertToCategoryDTO(Category category) {
        CategoryDTO categoryDTO = new CategoryDTO();
        categoryDTO.setName(category.getName());
        categoryDTO.setCategoryId(category.getCategoryId());
        categoryDTO.setDescription(category.getDescription());
        categoryDTO.setImageUrl(category.getImageUrl());

        return categoryDTO;
    }
}
