package com.example.productcatalogdemo.controllers;

import com.example.productcatalogdemo.dtos.CategoryDTO;
import com.example.productcatalogdemo.dtos.ProductDTO;
import com.example.productcatalogdemo.models.Product;
import com.example.productcatalogdemo.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {


    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public ResponseEntity<List<ProductDTO>> getProducts() {
        List<Product> products = productService.fetchAllProducts();
        if(!products.isEmpty()){
            return new ResponseEntity<>(products.stream().map(this::mapToDTO).toList(), HttpStatus.OK) ;
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("category/{categoryId}")
    public ResponseEntity<List<ProductDTO>> getProductsByCategory(@PathVariable Long categoryId) {

        List<Product> products = productService.fetchAllProductsByCategory(categoryId);
        if(!products.isEmpty()){
            return new ResponseEntity<>(products.stream().map(this::mapToDTO).toList(), HttpStatus.OK) ;
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("{productId}")
    public ResponseEntity<ProductDTO> getProductById(@PathVariable("productId") Long id) {
        if(id == null || id <= 0){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        Product product = productService.getProductById(id);
        if (product != null) {
            return new ResponseEntity<>(mapToDTO(product), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<ProductDTO> createProduct(@RequestBody ProductDTO newProduct) {

        Product createdProduct = productService.createProduct(newProduct);
        if (createdProduct != null) {
            return new ResponseEntity<>(mapToDTO(createdProduct), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @PutMapping("{productId}")
    public ResponseEntity<ProductDTO> updateProduct(@PathVariable("productId") Long id, @RequestBody ProductDTO updateProduct) {
        if(id == null || id <= 0){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        Product updatedProduct = productService.updateProduct(id, updateProduct);
        if (updatedProduct != null) {
            return new ResponseEntity<>(mapToDTO(updatedProduct), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    private ProductDTO mapToDTO(Product product){
        ProductDTO dto = new ProductDTO();
        dto.setProductId(product.getProductId());
        dto.setName(product.getName());
        dto.setPrice(product.getPrice());
        dto.setDescription(product.getDescription());
        dto.setImageUrl(product.getImageUrl());
        CategoryDTO categoryDTO = new CategoryDTO();
        categoryDTO.setName(product.getCategory().getName());
        categoryDTO.setDescription(product.getCategory().getDescription());
        dto.setCategory(categoryDTO);

        return dto;
    }
}
