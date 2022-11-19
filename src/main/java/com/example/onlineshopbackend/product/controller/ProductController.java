package com.example.onlineshopbackend.product.controller;

import com.example.onlineshopbackend.product.model.Product;
import com.example.onlineshopbackend.product.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RestController;

import javax.print.PrintService;
import java.math.BigDecimal;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping("/products")
    public List<?> getProducts() {
        return   productService.getProducts();
    }
}
