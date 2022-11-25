package com.example.onlineshopbackend.admin.product.controller.dto;

import lombok.Getter;

import java.math.BigDecimal;

@Getter
public class AdminProductDto {

    private Long id;
    private String name;
    private String description;
    private String category;
    private BigDecimal price;
    private String currency;
}
