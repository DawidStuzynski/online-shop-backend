package com.example.onlineshopbackend.admin.category;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "category")
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AdminCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String name;
    private String description;
    private String slug;
}
