package com.tobeto.pair7Demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.tobeto.pair7Demo.entities.Product;


public interface ProductRepository extends JpaRepository <Product,Integer > {
}
