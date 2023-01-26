package com.example.onlineshopbackend.category.model;

import com.example.onlineshopbackend.product.controller.dto.ProductListDto;
import com.example.onlineshopbackend.product.model.Product;
import org.springframework.data.domain.Page;

public record CategoryProductsDto(Category category, Page<ProductListDto> products) {
}
