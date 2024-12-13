package com.example.productcatalogdemo.controllers;

import com.example.productcatalogdemo.models.Category;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {

    @GetMapping
    public List<Category> getCategory() {
        Category category = new Category();
        category.setId(2L);
        category.setName("Mobiles");
        List<Category> categories = new ArrayList<>();
        categories.add(category);
        return categories;
    }

    @GetMapping("{id}")
    public Category getCategoryById(@PathVariable Long id) {
        Category category = new Category();
        category.setId(id);
        category.setName("Mobiles");
        return category;
    }
}
