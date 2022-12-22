package com.example.onlineshopbackend.admin.category.repository;


import com.example.onlineshopbackend.admin.category.AdminCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminCategoryRepository extends JpaRepository<AdminCategory, Long> {

}
