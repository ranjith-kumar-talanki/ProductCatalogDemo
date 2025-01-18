package com.example.productcatalogdemo.controllers;

import com.example.productcatalogdemo.dtos.CategoryDTO;
import com.example.productcatalogdemo.dtos.ProductDTO;
import com.example.productcatalogdemo.models.Category;
import com.example.productcatalogdemo.models.Product;
import com.example.productcatalogdemo.services.ProductService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(ProductController.class)
public class ProductControllerMvcTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private ProductService productService;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void test_GetproductById_Success() throws Exception {

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

        ProductDTO productDTO = new ProductDTO();
        productDTO.setProductId(1L);
        productDTO.setPartNumber("12345");
        productDTO.setName("test");
        productDTO.setImageUrl("https://www.baidu.com");
        productDTO.setDescription("desc");

        CategoryDTO categoryDTO = new CategoryDTO();
        categoryDTO.setCategoryId(1L);
        categoryDTO.setName("test");
        productDTO.setCategory(categoryDTO);

        when(productService.getProductById(1L)).thenReturn(product);

        mockMvc.perform(get("/products/{productId}", 1L)).andExpect(status().isOk())
                .andExpect(content().string(objectMapper.writeValueAsString(productDTO)));
    }

    @Test
    public void test_getAllProducts_Success() throws Exception {
        Product product1 = new Product();
        product1.setProductId(1L);
        product1.setPartNumber("12345-1");
        product1.setName("test1");
        product1.setImageUrl("https://www.baidu.com");
        product1.setDescription("desc");
        Category category1 = new Category();
        category1.setCategoryId(1L);
        category1.setName("test");
        product1.setCategory(category1);

        Product product2 = new Product();
        product2.setProductId(2L);
        product2.setPartNumber("12345-2");
        product2.setName("test2");
        product2.setImageUrl("https://www.baidu.com");
        product2.setDescription("desc");
        Category category2 = new Category();
        category2.setCategoryId(1L);
        category2.setName("test3");
        product2.setCategory(category2);

        Product product3 = new Product();
        product3.setProductId(3L);
        product3.setPartNumber("12345-3");
        product3.setName("test4");
        product3.setImageUrl("https://www.baidu.com");
        product3.setDescription("desc");
        Category category3 = new Category();
        category3.setCategoryId(1L);
        category3.setName("test");
        product3.setCategory(category3);

        Product product4 = new Product();
        product4.setProductId(3L);
        product4.setPartNumber("12345-4");
        product4.setName("test");
        product4.setImageUrl("https://www.baidu.com");
        product4.setDescription("desc");
        Category category4 = new Category();
        category4.setCategoryId(1L);
        category4.setName("test");
        product4.setCategory(category4);

        ArrayList<Product> products = new ArrayList<Product>();
        products.add(product1);
        products.add(product2);
        products.add(product3);
        products.add(product4);

        ProductDTO product1DTO = new ProductDTO();
        product1DTO.setProductId(1L);
        product1DTO.setPartNumber("12345-1");
        product1DTO.setName("test1");
        product1DTO.setImageUrl("https://www.baidu.com");
        product1DTO.setDescription("desc");
        CategoryDTO category1DTO = new CategoryDTO();
        category1DTO.setCategoryId(1L);
        category1DTO.setName("test");
        product1DTO.setCategory(category1DTO);

        ProductDTO product2DTO = new ProductDTO();
        product2DTO.setProductId(2L);
        product2DTO.setPartNumber("12345-2");
        product2DTO.setName("test2");
        product2DTO.setImageUrl("https://www.baidu.com");
        product2DTO.setDescription("desc");
        CategoryDTO category2DTO = new CategoryDTO();
        category2DTO.setCategoryId(1L);
        category2DTO.setName("test3");
        product2DTO.setCategory(category2DTO);

        ProductDTO product3DTO = new ProductDTO();
        product3DTO.setProductId(3L);
        product3DTO.setPartNumber("12345-3");
        product3DTO.setName("test3");
        product3DTO.setImageUrl("https://www.baidu.com");
        product3DTO.setDescription("desc");
        CategoryDTO category3DTO = new CategoryDTO();
        category3DTO.setCategoryId(1L);
        category3DTO.setName("test");
        product3DTO.setCategory(category3DTO);

        ProductDTO product4DTO = new ProductDTO();
        product4DTO.setProductId(3L);
        product4DTO.setPartNumber("12345-4");
        product4DTO.setName("test4");
        product4DTO.setImageUrl("https://www.baidu.com");
        product4DTO.setDescription("desc");
        CategoryDTO category4DTO = new CategoryDTO();
        category4DTO.setCategoryId(1L);
        category4DTO.setName("test");
        product4DTO.setCategory(category4DTO);

        ArrayList<ProductDTO> productsDTO = new ArrayList<>();
        productsDTO.add(product1DTO);
        productsDTO.add(product2DTO);
        productsDTO.add(product3DTO);
        productsDTO.add(product4DTO);

        when(productService.fetchAllProducts()).thenReturn(products);
        mockMvc.perform(get("/products")).andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(products.size()))
                .andExpect(jsonPath("$[0].productId").value(product1DTO.getProductId()))
                .andExpect(content().string(objectMapper.writeValueAsString(productsDTO)));
    }
}
