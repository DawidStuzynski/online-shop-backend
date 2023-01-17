package com.example.onlineshopbackend.admin.product.controller.dto;

import com.example.onlineshopbackend.admin.product.model.AdminProductCurrency;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Getter
@AllArgsConstructor
public class AdminProductDto {

    @NotBlank
    @Length(min = 4)
    private String name;

    @NotBlank
    @Length(min = 4)
    private String description;

    @NotNull
    private Long categoryId;

    @NotNull
    @Min(0)
    private BigDecimal price;

    private AdminProductCurrency currency;

    private String image;

    private String slug;
}
