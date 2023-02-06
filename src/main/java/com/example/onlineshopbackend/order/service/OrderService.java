package com.example.onlineshopbackend.order.service;


import com.example.onlineshopbackend.common.model.Cart;
import com.example.onlineshopbackend.common.model.CartItem;
import com.example.onlineshopbackend.common.repository.CartItemRepository;
import com.example.onlineshopbackend.common.repository.CartRepository;
import com.example.onlineshopbackend.order.model.Order;
import com.example.onlineshopbackend.order.model.OrderRow;
import com.example.onlineshopbackend.order.model.OrderStatus;
import com.example.onlineshopbackend.order.model.dto.OrderDto;
import com.example.onlineshopbackend.order.model.dto.OrderSummary;
import com.example.onlineshopbackend.order.repository.OrderRepository;
import com.example.onlineshopbackend.order.repository.OrderRowRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;
    private final CartRepository cartRepository;
    private final OrderRowRepository orderRowRepository;
    private final CartItemRepository cartItemRepository;

    public OrderSummary placeOrder(OrderDto orderDto) {
        Cart cart = cartRepository.findById(orderDto.getCartId()).orElseThrow();

        Order order = Order.builder()
                .firstname(orderDto.getFirstname())
                .lastname(orderDto.getLastname())
                .street(orderDto.getStreet())
                .zipcode(orderDto.getZipcode())
                .city(orderDto.getCity())
                .email(orderDto.getEmail())
                .phone(orderDto.getPhone())
                .placeDate(LocalDateTime.now())
                .orderStatus(OrderStatus.NEW)
                .grossValue(calculateGrossValue(cart.getItems()))
                .build();

        Order newOrder = orderRepository.save(order);
        saveOrderRows(cart, newOrder.getId());

        cartItemRepository.deleteByCartId(orderDto.getCartId());
        cartRepository.deleteCartById(orderDto.getCartId());

        return OrderSummary.builder()
                .id(newOrder.getId())
                .placeDate(newOrder.getPlaceDate())
                .status(newOrder.getOrderStatus())
                .grossValue(newOrder.getGrossValue())
                .build();
    }

    private BigDecimal calculateGrossValue(List<CartItem> items) {

        return items.stream()
                .map(cartItem -> cartItem.getProduct().getPrice().multiply(BigDecimal.valueOf(cartItem.getQuantity())))
                .reduce(BigDecimal::add)
                .orElse(BigDecimal.ZERO);
    }

    private void saveOrderRows(Cart cart, Long id) {

        cart.getItems().stream()
                .map(cartItem -> OrderRow.builder()
                        .quantity(cartItem.getQuantity())
                        .productId(cartItem.getProduct().getId())
                        .price(cartItem.getProduct().getPrice())
                        .orderId(id)
                        .build()
                ).peek(orderRowRepository::save)
                .toList();
    }

}
