package com.example.productcatalogdemo.models.tableInheritence.mappedsuperclass;

import jakarta.persistence.Entity;

@Entity(name = "mps_ta")
public class TeachingAssistant extends User{

    private int helpRequests;
}
