package com.example.productcatalogdemo.controllers;

import com.example.productcatalogdemo.models.Product;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    @GetMapping
    public List<Product> getProducts() {
        Product newProduct = new Product();
        newProduct.setId(1L);
        ArrayList<Product> products = new ArrayList<>();
        products.add(newProduct);

        return products;
    }

    @GetMapping("{productId}")
    public Product getProductById(@PathVariable("productId") Long id) {
        Product newProduct = new Product();
        newProduct.setId(id);

        return newProduct;
    }

    @PostMapping
    public Product createProduct(@RequestBody Product newProduct) {

        return newProduct;
    }
}
