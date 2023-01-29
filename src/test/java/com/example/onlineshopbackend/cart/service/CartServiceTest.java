package com.example.onlineshopbackend.cart.service;

import com.example.onlineshopbackend.cart.model.Cart;
import com.example.onlineshopbackend.cart.model.dto.CartProductDto;
import com.example.onlineshopbackend.cart.repository.CartRepository;
import com.example.onlineshopbackend.common.model.Product;
import com.example.onlineshopbackend.common.repository.ProductRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

class CartServiceTest {

    @Mock
    private CartRepository cartRepository;
    @Mock
    private ProductRepository productRepository;
    @InjectMocks
    private CartService cartService;


    @Test
    void shouldAddProductToCartWhenCartIdNotExists() {

        //given
        Long cartId = 0L;
        CartProductDto cartProductDto = new CartProductDto(1L, 1);
        when(productRepository.findById(1L)).thenReturn(Optional.of(Product.builder().id(1L).build()));
        when(cartRepository.save(any())).thenReturn(Cart.builder().id(1L).build());
        //when
        Cart result = cartService.addProductToCart(cartId, cartProductDto);
        //then
        assertThat(result).isNotNull();
        assertThat(result.getId()).isEqualTo(1L);
    }
    @Test
    void shouldAddProductToCartWhenCartIdExists(){
        //given
        Long cartId = 1L;
        CartProductDto cartProductDto = new CartProductDto(1L, 1);
        when(productRepository.findById(1L)).thenReturn(Optional.of(Product.builder().id(1L).build()));
        when(cartRepository.findById(cartId)).thenReturn(Optional.of(Cart.builder().id(1L).build()));
        //when
        Cart result = cartService.addProductToCart(cartId, cartProductDto);
        //then
        assertThat(result).isNotNull();
        assertThat(result.getId()).isEqualTo(1L);
    }
}