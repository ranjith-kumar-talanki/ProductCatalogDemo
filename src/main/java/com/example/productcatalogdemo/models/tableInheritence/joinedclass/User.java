package com.example.productcatalogdemo.models.tableInheritence.joinedclass;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;

import java.util.UUID;

@Entity(name = "jc_user")
@Inheritance(strategy = InheritanceType.JOINED)
public class User {

    @Id
    private UUID id;
    private String name;
    private String email;
}
