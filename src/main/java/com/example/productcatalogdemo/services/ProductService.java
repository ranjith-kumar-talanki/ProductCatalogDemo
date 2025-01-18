package com.example.productcatalogdemo.services;

import com.example.productcatalogdemo.dtos.ProductDTO;
import com.example.productcatalogdemo.models.Product;
import java.util.List;
import java.util.NoSuchElementException;

public interface ProductService {

    List<Product> fetchAllProducts();
    List<Product> fetchAllActiveProducts();
    Product getProductById(Long productId) throws NoSuchElementException;
    Product createProduct(ProductDTO newProduct) throws NoSuchElementException;
    Product updateProduct(Long productId, ProductDTO product) throws NoSuchElementException;
    List<Product> fetchAllProductsByCategory(Long categoryId);
    void deleteProduct(Long productId) throws NoSuchElementException;
}
