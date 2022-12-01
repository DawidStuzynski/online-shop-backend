package com.example.onlineshopbackend.admin.product.controller;


import com.example.onlineshopbackend.admin.product.controller.dto.AdminProductDto;
import com.example.onlineshopbackend.admin.product.controller.dto.UploadResponse;
import com.example.onlineshopbackend.admin.product.model.AdminProduct;
import com.example.onlineshopbackend.admin.product.service.AdminProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

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
    public AdminProduct createProduct(@Valid @RequestBody AdminProductDto adminProductDto) {
        return productService.createProduct(mapAdminProduct(adminProductDto, EMPTY_ID));
    }

    @PutMapping("/admin/products/{id}")
    public AdminProduct updateProduct(@Valid @RequestBody AdminProductDto adminProductDto, @PathVariable Long id) {
        return productService.updateProduct(mapAdminProduct(adminProductDto, id));
    }

    @DeleteMapping("/admin/products/{id}")
    public void deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
    }

    public UploadResponse uploadImage(@RequestParam("file") MultipartFile multipartFile) {
        String filename = multipartFile.getOriginalFilename();
        String uploadDir = "./data/productImages";

        Path filePath = Paths.get(uploadDir).resolve(filename);

        try (InputStream inputStream = multipartFile.getInputStream()) {
            OutputStream outputStream = Files.newOutputStream(filePath);
            inputStream.transferTo(outputStream);
            return new UploadResponse(filename);
        } catch (IOException e) {
            throw new RuntimeException("File cannot be saved", e);
        }
    }


    private AdminProduct mapAdminProduct(AdminProductDto adminProductDto, Long id) {
        return productService.createProduct(AdminProduct.builder().id(id).name(adminProductDto.getName()).description(adminProductDto.getDescription()).category(adminProductDto.getCategory()).price(adminProductDto.getPrice()).currency(adminProductDto.getCurrency()).image(adminProductDto.getImage()).build());
    }

}
