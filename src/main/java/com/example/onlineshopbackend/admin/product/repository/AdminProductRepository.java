package com.example.onlineshopbackend.admin.product.repository;

import com.example.onlineshopbackend.admin.product.model.AdminProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminProductRepository extends JpaRepository<AdminProduct, Long> {
}
