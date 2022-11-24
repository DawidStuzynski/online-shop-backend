package com.example.onlineshopbackend.admin.product.repository;

import com.example.onlineshopbackend.admin.product.model.AdminProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.Table;

@Repository
@Table(name = "product")
public interface AdminProductRepository extends JpaRepository<AdminProduct, Long> {
}
