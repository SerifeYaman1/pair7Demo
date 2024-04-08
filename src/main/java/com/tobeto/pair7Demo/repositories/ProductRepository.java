package com.tobeto.pair7Demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.tobeto.pair7Demo.entities.Product;

import java.util.Optional;


public interface ProductRepository extends JpaRepository <Product,Integer > {
    Optional<Product> findByNameIgnoreCase(String name);
}
