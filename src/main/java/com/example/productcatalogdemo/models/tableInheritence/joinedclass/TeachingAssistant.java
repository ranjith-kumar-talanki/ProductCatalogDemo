package com.example.productcatalogdemo.models.tableInheritence.joinedclass;

import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;

@Entity(name = "jc_ta")
@PrimaryKeyJoinColumn(name = "user_id")
public class TeachingAssistant extends User{
    private int helpRequests;
}
