package com.example.onlineshopbackend.admin.product.model;


import lombok.Getter;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "product")
@Getter
public class AdminProduct {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String name;
    private String category;
    private String description;
    private BigDecimal price;
    private String currency;
}
