package com.example.onlineshopbackend.admin.category.controller;


import com.example.onlineshopbackend.admin.category.AdminCategory;
import com.example.onlineshopbackend.admin.category.controller.dto.AdminCategoryDto;
import com.example.onlineshopbackend.admin.category.service.AdminCategoryService;
import com.github.slugify.Slugify;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.example.onlineshopbackend.admin.product.controller.AdminProductController.EMPTY_ID;

@RestController
@RequestMapping("/admin/categories")
@RequiredArgsConstructor
public class AdminCategoryController {

    public static final Long EMPTY_ID = null;

    private final AdminCategoryService adminCategoryService;

    @GetMapping
    public List<AdminCategory> getCategories() {
        return adminCategoryService.getCategories();
    }

    @GetMapping("/{id}")
    public AdminCategory getCategory(@PathVariable Long id) {
        return adminCategoryService.getCategory(id);
    }

    @PostMapping()
    public AdminCategory createCategory(@RequestBody AdminCategoryDto adminCategoryDto) {
        return adminCategoryService.createCategory(mapToAdminCategory(EMPTY_ID, adminCategoryDto));
    }

    private AdminCategory mapToAdminCategory(Long id, AdminCategoryDto adminCategoryDto) {

        return AdminCategory.builder()
                .name(adminCategoryDto.getName())
                .description(adminCategoryDto.getDescription())
                .slug(slugifyCategoryName(adminCategoryDto.getSlug()))
                .build();
    }

    private String slugifyCategoryName(String slug) {
        Slugify slugify = new Slugify();
        return slugify.withCustomReplacement("_", "-")
                .slugify(slug);

    }

    @PutMapping("/{id}")
    public AdminCategory updateCategory(@PathVariable Long id, @RequestBody AdminCategoryDto adminCategoryDto) {
        return adminCategoryService.updateCategory(mapToAdminCategory(id, adminCategoryDto));
    }


    @DeleteMapping("/{id}")
    public void deleteCategory(@PathVariable Long id) {
        adminCategoryService.deleteCategory(id);
    }


}
