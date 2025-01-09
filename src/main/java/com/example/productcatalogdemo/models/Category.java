package com.example.productcatalogdemo.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.DynamicInsert;

import java.util.List;

@Getter
@Setter
@Entity(name = "catgroup")
@DynamicInsert
public class Category extends BaseModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "catgroup_id")
    private Long categoryId;
    @Column(unique = true, nullable = false)
    private String name;
    private String description;
    private String imageUrl;
    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
    private List<Product> products;
}
