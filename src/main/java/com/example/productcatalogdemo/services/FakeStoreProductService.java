package com.example.productcatalogdemo.services;

import com.example.productcatalogdemo.clients.FakeStoreProductsAPIClient;
import com.example.productcatalogdemo.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FakeStoreProductService implements ProductService {

    private final FakeStoreProductsAPIClient fakeStoreProductsAPIClient;

    @Autowired
    public FakeStoreProductService(FakeStoreProductsAPIClient fakeStoreProductsAPIClient) {
        this.fakeStoreProductsAPIClient = fakeStoreProductsAPIClient;
    }

    public List<Product> fetchAll() {
        return fakeStoreProductsAPIClient.fetchAllProducts();
    }

    public Product getProductById(Long id) {
        return fakeStoreProductsAPIClient.getProductById(id);
    }

    public Product createProduct(Product product) {
        return fakeStoreProductsAPIClient.createProduct(product);
    }

    public Product updateProduct(long productId, Product product) {
        return fakeStoreProductsAPIClient.updateProduct(productId, product);
    }


}
