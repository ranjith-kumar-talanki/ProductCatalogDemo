package com.example.productcatalogdemo.models.tableInheritence.mappedsuperclass;

import jakarta.persistence.Entity;

@Entity(name = "mps_instructor")
public class Instructor extends User{
    private String company;
    private double rating;
}
