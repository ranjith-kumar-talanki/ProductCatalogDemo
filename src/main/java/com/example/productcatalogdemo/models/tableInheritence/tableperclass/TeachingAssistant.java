package com.example.productcatalogdemo.models.tableInheritence.tableperclass;

import jakarta.persistence.Entity;

@Entity(name = "tpc_ta")
public class TeachingAssistant extends User{

    private int helpRequests;
}
