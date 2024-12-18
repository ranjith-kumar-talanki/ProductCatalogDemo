package com.example.productcatalogdemo.dtos;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ProductDTO {

    private long id;
    private String name;
    private double price;
    private String description;
    private String imageUrl;
    private CategoryDTO category;
}
