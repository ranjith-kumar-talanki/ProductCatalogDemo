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
import java.util.NoSuchElementException;

@Service
@Primary
public class StoreProductService implements ProductService {

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
    public List<Product> fetchAllActiveProducts() {
        return productRepository.findAllByMarkForDelete(0);
    }

    @Override
    public Product getProductById(Long productId) throws NoSuchElementException {
        return productRepository.findById(productId).orElseThrow(() -> new NoSuchElementException("Product not found with id: " + productId));
    }

    @Override
    public Product createProduct(ProductDTO newProduct) throws NoSuchElementException {
        Category productCategory = categoryRepository.findById(newProduct.getCategory().getCategoryId()).orElseThrow(() -> new NoSuchElementException("Category not found with id: " + newProduct.getCategory().getCategoryId()));
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
    public Product updateProduct(Long productId, ProductDTO productDTO) throws NoSuchElementException {
        Product product = productRepository.findById(productId).orElseThrow(() -> new NoSuchElementException("Product not found with id: " + productId));
        product.setName(productDTO.getName());
        product.setDescription(productDTO.getDescription());
        product.setPrice(productDTO.getPrice());
        product.setImageUrl(productDTO.getImageUrl());
        productRepository.save(product);
        return product;
    }

    @Override
    public List<Product> fetchAllProductsByCategory(Long categoryId) {
        Category category = categoryRepository.findById(categoryId).orElseThrow(() -> new NoSuchElementException("Category not found with id: " + categoryId));
        return productRepository.findAllByCategory(category);
    }

    @Override
    public void deleteProduct(Long productId) throws NoSuchElementException {
        Product product = productRepository.findById(productId).orElseThrow(() -> new NoSuchElementException("Product not found with id: " + productId));
        product.setMarkForDelete(1);
        productRepository.save(product);

    }

}
