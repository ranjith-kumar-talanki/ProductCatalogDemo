package com.example.productcatalogdemo.dtos;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProductDTO {

    private long productId;
    private String partNumber;
    private String name;
    private double price;
    private String description;
    private String imageUrl;
    private CategoryDTO category;
}
