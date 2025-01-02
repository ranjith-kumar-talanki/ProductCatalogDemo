package com.example.productcatalogdemo.models.tableInheritence.singletable;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity(name = "st_instructor")
@DiscriminatorValue(value = "INST")
public class Instructor extends User{

    private String company;
    private double rating;
}
