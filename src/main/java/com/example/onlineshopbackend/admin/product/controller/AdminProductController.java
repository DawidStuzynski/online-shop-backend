package com.example.onlineshopbackend.admin.product.controller;


import com.example.onlineshopbackend.admin.product.controller.dto.AdminProductDto;
import com.example.onlineshopbackend.admin.product.model.AdminProduct;
import com.example.onlineshopbackend.admin.product.service.AdminProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class AdminProductController {

    public static final Long EMPTY_ID = null;
    private final AdminProductService productService;

    @GetMapping("/admin/products")
    public Page<AdminProduct> getProducts(Pageable pageable) {
        return productService.getProducts(pageable);
    }

    @GetMapping("/admin/products/{id}")
    public AdminProduct getProduct(@PathVariable Long id) {
        return productService.getProduct(id);
    }

    @PostMapping("/admin/products")
    public AdminProduct createProduct(@RequestBody AdminProductDto adminProductDto) {
        return productService.createProduct(mapAdminProduct(adminProductDto, EMPTY_ID));
    }

    @PutMapping("/admin/products{id}")
    public AdminProduct updateProduct(@RequestBody AdminProductDto adminProductDto, @PathVariable Long id) {
        return productService.updateProduct(mapAdminProduct(adminProductDto, id));
    }

    private AdminProduct mapAdminProduct(AdminProductDto adminProductDto, Long id) {
        return productService.createProduct(AdminProduct.builder()
                .name(adminProductDto.getName())
                .description(adminProductDto.getDescription())
                .category(adminProductDto.getCategory())
                .price(adminProductDto.getPrice())
                .currency(adminProductDto.getCurrency())
                .build()
        );
    }

}
