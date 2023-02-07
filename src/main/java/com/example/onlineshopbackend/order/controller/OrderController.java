package com.example.onlineshopbackend.order.controller;

import com.example.onlineshopbackend.order.model.dto.OrderDto;
import com.example.onlineshopbackend.order.model.dto.OrderSummary;
import com.example.onlineshopbackend.order.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @PostMapping
    public OrderSummary placeOrder(@RequestBody OrderDto orderDto) {
        return orderService.placeOrder(orderDto);
    }

}
