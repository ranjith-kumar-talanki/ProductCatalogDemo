package com.example.productcatalogdemo.models.tableInheritence.mappedsuperclass;

import jakarta.persistence.Entity;

@Entity(name = "mps_mentor")
public class Mentor extends User{

    private double rating;
}
