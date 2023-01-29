package com.example.onlineshopbackend.cart.controller;

import com.example.onlineshopbackend.cart.model.dto.CartProductDto;
import com.example.onlineshopbackend.cart.model.Cart;
import com.example.onlineshopbackend.cart.service.CartService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/carts")
@RequiredArgsConstructor
public class CartController {

    private final CartService cartService;

    @GetMapping("/{id}")
    public Cart getCart(@PathVariable Long id) {
        return cartService.getCart(id);
    }

    @PutMapping("/{id}")
    public Cart addProductToCart(@PathVariable Long id, @RequestBody CartProductDto cartProductDto) {
        return cartService.addProductToCart(id, cartProductDto);
    }

}
