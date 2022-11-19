package com.example.onlineshopbackend.product.repository;

import com.example.onlineshopbackend.product.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {


}
