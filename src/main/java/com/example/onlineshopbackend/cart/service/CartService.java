package com.example.onlineshopbackend.cart.service;

import com.example.onlineshopbackend.cart.model.Cart;
import com.example.onlineshopbackend.cart.repository.CartRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CartService {

    private final CartRepository cartRepository;

    public Cart getCart(Long id) {
        return cartRepository.findById(id).orElseThrow();
    }
}