package com.example.productcatalogdemo.services;

import com.example.productcatalogdemo.models.Product;
import java.util.List;

public interface ProductService {

    List<Product> fetchAll();
    Product getProductById(Long id);
    Product createProduct(Product product);
    Product updateProduct(long productId, Product product);
}
