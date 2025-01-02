package com.example.productcatalogdemo.models.tableInheritence.singletable;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity(name = "st_mentor")
@DiscriminatorValue(value = "MNTR")
public class Mentor extends User{

    private double rating;
}
