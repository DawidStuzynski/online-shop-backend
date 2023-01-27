package com.example.onlineshopbackend.category.dto;

import com.example.onlineshopbackend.common.model.Category;
import com.example.onlineshopbackend.common.dto.ProductListDto;
import org.springframework.data.domain.Page;

public record CategoryProductsDto(Category category, Page<ProductListDto> products) {
}
