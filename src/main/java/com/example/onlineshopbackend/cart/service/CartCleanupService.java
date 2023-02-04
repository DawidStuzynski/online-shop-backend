package com.example.onlineshopbackend.cart.service;

import com.example.onlineshopbackend.cart.model.Cart;
import com.example.onlineshopbackend.cart.repository.CartItemRepository;
import com.example.onlineshopbackend.cart.repository.CartRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class CartCleanupService {

    private final CartRepository cartRepository;
    private final CartItemRepository cartItemRepository;


    @Transactional
    @Scheduled(cron = "${app.cart.cleanup.expression}")
    public void cleanupOldCart() {
        List<Cart> carts = cartRepository.findByCreatedLessThan(LocalDateTime.now().minusDays(3));
        log.info("Old carts " + carts.size());

        List<Long> ids = carts.stream()
                .map(Cart::getId)
                .toList();

        if (!ids.isEmpty()) {
            cartItemRepository.deleteAllByCartIdIn(ids);
            cartRepository.deleteAllByIdIn(ids);
        }
    }
}
