package com.example.productcatalogdemo.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FakeStoreProductDTO {

    private long id;
    private String title;
    private double price;
    private String description;
    private String image;
    private String category;
}
