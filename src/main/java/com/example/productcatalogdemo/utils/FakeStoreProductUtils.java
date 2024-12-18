package com.example.productcatalogdemo.utils;

import com.example.productcatalogdemo.dtos.FakeStoreProductDTO;
import com.example.productcatalogdemo.models.Category;
import com.example.productcatalogdemo.models.Product;
import lombok.experimental.UtilityClass;

@UtilityClass
public class FakeStoreProductUtils {

    public static Product mapper(FakeStoreProductDTO fakeStoreProduct) {
        Product product = new Product();
        product.setId(fakeStoreProduct.getId());
        product.setName(fakeStoreProduct.getTitle());
        product.setPrice(fakeStoreProduct.getPrice());
        product.setDescription(fakeStoreProduct.getDescription());
        product.setImageUrl(fakeStoreProduct.getImage());
        Category category = new Category();
        category.setName(fakeStoreProduct.getCategory());
        product.setCategory(category);

        return product;
    }

    public static FakeStoreProductDTO mapToFakeStoreProductDTO(Product product) {
        FakeStoreProductDTO fakeStoreProductDTO = new FakeStoreProductDTO();
        fakeStoreProductDTO.setTitle(product.getName());
        fakeStoreProductDTO.setPrice(product.getPrice());
        fakeStoreProductDTO.setDescription(product.getDescription());
        fakeStoreProductDTO.setImage(product.getImageUrl());
        fakeStoreProductDTO.setCategory(product.getCategory().getName());
        return fakeStoreProductDTO;
    }
}
