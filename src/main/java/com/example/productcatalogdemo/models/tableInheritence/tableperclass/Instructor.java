package com.example.productcatalogdemo.models.tableInheritence.tableperclass;

import jakarta.persistence.Entity;

@Entity(name = "tpc_instructor")
public class Instructor extends User{
    private String company;
    private double rating;
}
