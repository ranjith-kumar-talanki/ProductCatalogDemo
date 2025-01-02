package com.example.productcatalogdemo.models.tableInheritence.singletable;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity(name = "st_ta")
@DiscriminatorValue(value = "TA")
public class TeachingAssistant extends User{
    private int helpRequests;
}
