package com.example.productcatalogdemo.services;

import com.example.productcatalogdemo.dtos.ProductDTO;
import com.example.productcatalogdemo.models.Product;
import java.util.List;

public interface ProductService {

    List<Product> fetchAllProducts();
    Product getProductById(Long productId);
    Product createProduct(ProductDTO newProduct);
    Product updateProduct(Long productId, ProductDTO product);
    List<Product> fetchAllProductsByCategory(Long categoryId);
    void deleteProduct(Long productId);
}
