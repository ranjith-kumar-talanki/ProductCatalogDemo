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
            List<CategoryDTO> categoriesDTO = categoryService.getAllCategories().stream().map(this::convertToCategoryDTO).toList();
            return new ResponseEntity<>(categoriesDTO, HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
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

    private CategoryDTO convertToCategoryDTO(Category category) {
        CategoryDTO categoryDTO = new CategoryDTO();
        categoryDTO.setName(category.getName());
        categoryDTO.setCategoryId(category.getCategoryId());
        categoryDTO.setDescription(category.getDescription());
        categoryDTO.setImageUrl(category.getImageUrl());

        return categoryDTO;
    }
}
