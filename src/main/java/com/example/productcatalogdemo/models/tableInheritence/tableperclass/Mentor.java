package com.example.productcatalogdemo.models.tableInheritence.tableperclass;

import jakarta.persistence.Entity;

@Entity(name="tpc_mentor")
public class Mentor extends User{

    private double rating;
}
