package com.example.productcatalogdemo.controllers;

import com.example.productcatalogdemo.dtos.CategoryDTO;
import com.example.productcatalogdemo.models.Category;
import com.example.productcatalogdemo.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("products/categories")
public class CategoryController {

    private final ProductService productService;

    @Autowired
    public CategoryController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public ResponseEntity<List<CategoryDTO>> getAllCategories() {

        List<Category> allCategories = productService.getAllCategories();
        if(!allCategories.isEmpty()) {
            List<CategoryDTO> categories = allCategories.stream().map(category -> {
                CategoryDTO categoryDTO = new CategoryDTO();
                categoryDTO.setName(category.getName());
                return categoryDTO;
            }).toList();

            return new ResponseEntity<>(categories, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
