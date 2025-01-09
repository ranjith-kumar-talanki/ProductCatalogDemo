package com.example.productcatalogdemo.services;

import com.example.productcatalogdemo.dtos.ProductDTO;
import com.example.productcatalogdemo.models.Category;
import com.example.productcatalogdemo.models.Product;
import com.example.productcatalogdemo.repositories.CategoryRepository;
import com.example.productcatalogdemo.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Primary
public class StoreProductService implements ProductService{

    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;

    @Autowired
    public StoreProductService(ProductRepository productRepository, CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<Product> fetchAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product getProductById(Long id) {
        Optional<Product> product = productRepository.findById(id);
        return product.orElse(null);
    }

    @Override
    public Product createProduct(ProductDTO newProduct) {
        Category productCategory = categoryRepository.findById(newProduct.getCategory().getCategoryId()).orElse(null);
        Product product = new Product();
        product.setName(newProduct.getName());
        product.setPartNumber(newProduct.getPartNumber());
        product.setCategory(productCategory);
        product.setDescription(newProduct.getDescription());
        product.setPrice(newProduct.getPrice());
        product.setImageUrl(newProduct.getImageUrl());
        productRepository.save(product);
        return product;
    }

    @Override
    public Product updateProduct(Long productId, ProductDTO product) {
        return null;
    }

    @Override
    public List<Product> fetchAllProductsByCategory(Long categoryId) {
        return List.of();
    }

    @Override
    public void deleteProduct(Long productId) {

    }

}
