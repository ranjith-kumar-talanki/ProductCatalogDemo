package com.example.productcatalogdemo.models.tableInheritence.mappedsuperclass;

import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;

import java.util.UUID;

@MappedSuperclass
public class User {
    @Id
    private UUID id;
    private String name;
    private String email;
}
