package com.example.productcatalogdemo.dtos;


import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CategoryDTO {
    private Long categoryId;
    private String name;
    private String description;
    private String imageUrl;
    private List<ProductDTO> products;
}
