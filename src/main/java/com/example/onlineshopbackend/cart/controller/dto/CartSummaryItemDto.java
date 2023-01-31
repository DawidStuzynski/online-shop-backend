package com.example.onlineshopbackend.cart.controller.dto;

import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;

@Getter
@Builder
public class CartSummaryItemDto {
    private Long id;
    private int quantity;
    private ProductDto product;
    private BigDecimal lineValue;
}
