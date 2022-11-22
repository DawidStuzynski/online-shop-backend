package com.example.onlineshopbackend.admin.product.controller;


import com.example.onlineshopbackend.admin.product.model.AdminProduct;
import com.example.onlineshopbackend.admin.product.service.AdminProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AdminProductController {

    private final AdminProductService ProductService;

    @GetMapping("/admin/products")
    public Page<AdminProduct> getProducts(Pageable pageable) {
        return ProductService.getProducts(pageable);
    }

    @GetMapping("/admin/products/{id}")
    public AdminProduct getProduct(@PathVariable Long id) {
        return ProductService.getProduct(id);
    }

}
