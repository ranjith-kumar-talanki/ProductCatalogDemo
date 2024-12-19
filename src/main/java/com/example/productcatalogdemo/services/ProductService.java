package com.example.productcatalogdemo.services;

import com.example.productcatalogdemo.models.Product;
import java.util.List;

public interface ProductService {

    List<Product> fetchAllProducts();
    Product getProductById(Long id);
    Product createProduct(Product product);
    Product updateProduct(long productId, Product product);
    List<Product> fetchAllProductsByCategory(String category);
}
