package com.example.productcatalogdemo.models;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Product extends BaseModel{
    private String name;
    private double price;
    private String description;
    private String imageUrl;
    private Category category;
}
