package com.example.onlineshopbackend.admin.product.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.math.BigDecimal;

@Entity
@Table(name = "product")
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AdminProduct {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String name;

    private Long categoryId;

    private String description;

    private BigDecimal price;

    @Enumerated(EnumType.STRING)
    private AdminProductCurrency currency;

    private String image;

    @NotBlank
    @Length(min = 4)
    private String slug;

}
