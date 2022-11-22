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

    public AdminProduct getProduct(Long id) {
        return productRepository.findById(id).orElseThrow();
    }

    public AdminProduct createProduct(AdminProduct product) {
        return productRepository.save(product);

    }

    public AdminProduct updateProduct(AdminProduct product) {
        return productRepository.save(product);
    }
}
