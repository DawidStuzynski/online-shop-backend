package com.example.onlineshopbackend.cart.service;

import com.example.onlineshopbackend.common.model.Cart;
import com.example.onlineshopbackend.common.model.CartItem;
import com.example.onlineshopbackend.cart.model.dto.CartProductDto;
import com.example.onlineshopbackend.common.repository.CartRepository;
import com.example.onlineshopbackend.common.model.Product;
import com.example.onlineshopbackend.common.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static java.time.LocalDateTime.now;

@Service
@RequiredArgsConstructor
public class CartService {

    private final CartRepository cartRepository;

    private final ProductRepository productRepository;

    public Cart getCart(Long id) {
        return cartRepository.findById(id).orElseThrow();
    }

    @Transactional
    public Cart addProductToCart(Long id, CartProductDto cartProductDto) {
        Cart cart = getInitialized(id);
        cart.addProduct(CartItem.builder()
                .quantity(cartProductDto.quantity())
                .product(getProduct(cartProductDto.productId()))
                .cartId(cart.getId())
                .build());
        return cart;
    }

    private Product getProduct(Long productId) {
        return productRepository.findById(productId).orElseThrow();
    }

    private Cart getInitialized(Long id) {
        if (id == null || id <= 0) {
            return cartRepository.save(Cart.builder().created(now()).build());
        }
        return cartRepository.findById(id).orElseThrow();
    }

    @Transactional
    public Cart updateCart(Long id, List<CartProductDto> cartProductDtos) {
        Cart cart = cartRepository.findById(id).orElseThrow();
        cart.getItems().forEach(cartItem -> {
            cartProductDtos.stream()
                    .filter(cartProductDto -> cartItem.getProduct().getId().equals(cartProductDto.productId()))
                    .findFirst()
                    .ifPresent(cartProductDto -> cartItem.setQuantity(cartProductDto.quantity()));
        });
        return cart;
    }
}
