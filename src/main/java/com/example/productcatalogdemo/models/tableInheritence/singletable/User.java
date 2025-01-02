package com.example.productcatalogdemo.models.tableInheritence.singletable;

import jakarta.persistence.*;

import java.util.UUID;

@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(discriminatorType = DiscriminatorType.STRING, name = "user_type")
@Entity(name = "stc_user")
public class User {

    @Id
    private UUID id;
    private String name;
    private String email;
}
