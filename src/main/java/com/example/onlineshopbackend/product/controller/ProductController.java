package com.example.onlineshopbackend.product.controller;

import com.example.onlineshopbackend.product.model.Product;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.List;

@RestController
public class ProductController {

    @GetMapping("/products")
    public List<?> getProducts() {
        return List.of(
                new Product("Product 1", "Category 1", "Description 1", new BigDecimal("8.99"), "PLN"),
                new Product("Product 2", "Category 2", "Description 2", new BigDecimal("8.99"), "PLN"),
                new Product("Product 3", "Category 3", "Description 3", new BigDecimal("8.99"), "PLN"),
                new Product("Product 4", "Category 4", "Description 4", new BigDecimal("8.99"), "PLN")
        );
    }
}
