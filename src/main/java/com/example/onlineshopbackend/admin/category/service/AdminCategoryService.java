package com.example.onlineshopbackend.admin.category.service;

import com.example.onlineshopbackend.admin.category.AdminCategory;
import com.example.onlineshopbackend.admin.category.repository.AdminCategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AdminCategoryService {

    private AdminCategoryRepository adminCategoryRepository;

    public List<AdminCategory> getCategories() {
        return adminCategoryRepository.findAll();
    }

    public AdminCategory getCategory(Long id) {
        return adminCategoryRepository.findById(id).orElseThrow();
    }

    public AdminCategory createCategory(AdminCategory adminCategory) {
        return adminCategoryRepository.save(adminCategory);
    }

    public AdminCategory updateCategory(AdminCategory adminCategory) {
        return adminCategoryRepository.save(adminCategory);
    }

    public void deleteCategory(Long id) {
        adminCategoryRepository.deleteById(id);
    }
}
