package com.example.productcatalogdemo.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.DynamicInsert;

@Setter
@Getter
@Entity(name = "catentry")
@DynamicInsert
public class Product extends BaseModel{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "catentry_id")
    private Long productId;
    @Column(unique = true, nullable = false)
    private String partNumber;
    private String name;
    private double price;
    private String description;
    private String imageUrl;
    @ManyToOne
    @JoinColumn(name = "catgroup_id")
    private Category category;
}
