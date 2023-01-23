package com.example.onlineshopbackend.category.service;

import com.example.onlineshopbackend.category.model.Category;
import com.example.onlineshopbackend.category.model.CategoryProductsDto;
import com.example.onlineshopbackend.category.repository.CategoryRepository;
import com.example.onlineshopbackend.product.model.Product;
import com.example.onlineshopbackend.product.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryRepository categoryRepository;
    private final ProductRepository productRepository;

    public List<Category> getCategories() {
        return categoryRepository.findAll();
    }

    @Transactional(readOnly = true)
    public CategoryProductsDto getCategoriesWithProducts(String slug, Pageable pageable) {
        Category category = categoryRepository.findBySlug(slug);
        Page<Product> page = productRepository.findByCategoryId(category.getId(), pageable);
        return new CategoryProductsDto(category, page);
    }
}
