package com.example.productcatalogdemo.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.DynamicInsert;

import java.util.List;


@Entity(name = "catgroup")
@DynamicInsert
@Data
@EqualsAndHashCode(callSuper = true)
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
