package com.example.productcatalogdemo.dtos;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ProductDTO {

    private long productId;
    private String partNumber;
    private String name;
    private double price;
    private String description;
    private String imageUrl;
    private CategoryDTO category;
}
