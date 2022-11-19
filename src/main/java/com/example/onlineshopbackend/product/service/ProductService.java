package com.example.onlineshopbackend.product.service;

import com.example.onlineshopbackend.product.model.Product;
import com.example.onlineshopbackend.product.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public List<Product> getProducts() {
        return productRepository.findAll();
    }

}
