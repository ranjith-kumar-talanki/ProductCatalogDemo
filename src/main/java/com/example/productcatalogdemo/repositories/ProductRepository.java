package com.example.productcatalogdemo.repositories;

import com.example.productcatalogdemo.models.Category;
import com.example.productcatalogdemo.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findAllByMarkForDelete(Integer markForDelete);
    List<Product> findAllByCategory(Category category);
}
