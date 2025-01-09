package com.example.productcatalogdemo.repositories;

import com.example.productcatalogdemo.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    Optional<Product> findProductByPartNumber(String partNumber);
}
