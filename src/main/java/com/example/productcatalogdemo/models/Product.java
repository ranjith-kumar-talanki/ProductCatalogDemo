package com.example.productcatalogdemo.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.DynamicInsert;

@Entity(name = "catentry")
@DynamicInsert
@Data
@EqualsAndHashCode(callSuper = true)
public class Product extends BaseModel {

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
