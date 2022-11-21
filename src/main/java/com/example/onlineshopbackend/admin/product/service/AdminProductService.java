package com.example.onlineshopbackend.admin.product.service;


import com.example.onlineshopbackend.admin.product.model.AdminProduct;
import com.example.onlineshopbackend.admin.product.repository.AdminProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AdminProductService {

    private final AdminProductRepository productRepository;

    public Page<AdminProduct> getProducts(Pageable pageable) {
        return productRepository.findAll(pageable);
    }
}