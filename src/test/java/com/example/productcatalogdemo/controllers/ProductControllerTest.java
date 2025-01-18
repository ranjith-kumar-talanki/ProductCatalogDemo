package com.example.productcatalogdemo.controllers;

import com.example.productcatalogdemo.dtos.ProductDTO;
import com.example.productcatalogdemo.models.Category;
import com.example.productcatalogdemo.models.Product;
import com.example.productcatalogdemo.services.ProductService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.bean.override.mockito.MockitoBean;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest
class ProductControllerTest {

    @Autowired
    private ProductController controller;

    @MockitoBean
    private ProductService productService;

    @Test
    public void test_GetProductById_ReturnProductSuccess() {

        ProductDTO productDTO = new ProductDTO();
        productDTO.setProductId(1L);
        productDTO.setPartNumber("12345");
        productDTO.setName("test");
        productDTO.setImageUrl("https://www.baidu.com");
        productDTO.setDescription("desc");

        Product product = new Product();
        product.setProductId(1L);
        product.setPartNumber("12345");
        product.setName("test");
        product.setImageUrl("https://www.baidu.com");
        product.setDescription("desc");
        Category category = new Category();
        category.setCategoryId(1L);
        category.setName("test");
        product.setCategory(category);

        when(productService.getProductById(1L)).thenReturn(product);
        ResponseEntity<ProductDTO> response = controller.getProductById(1L);
        assertNotNull(response);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
        assertEquals(productDTO.getProductId(), response.getBody().getProductId());
    }

    @Test
    public void test_GetProductById_ReturnProductNotFound() {

        when(productService.getProductById(1L)).thenReturn(null);
        ResponseEntity<ProductDTO> response = controller.getProductById(1L);
        assertNotNull(response);
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        assertNull(response.getBody());
    }

    @Test
    public void test_GetProductById_BadRequest() {
        when(productService.getProductById(0L)).thenReturn(null);
        ResponseEntity<ProductDTO> response = controller.getProductById(0L);
        assertNotNull(response);
        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
        assertNull(response.getBody());
    }
}