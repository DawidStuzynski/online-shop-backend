package com.example.onlineshopbackend.order.controller;

import com.example.onlineshopbackend.order.model.dto.InitOrder;
import com.example.onlineshopbackend.order.model.dto.OrderDto;
import com.example.onlineshopbackend.order.model.dto.OrderSummary;
import com.example.onlineshopbackend.order.service.OrderService;
import com.example.onlineshopbackend.order.service.ShipmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/orders")
public class OrderController {

    private final OrderService orderService;

    private final ShipmentService shipmentService;

    @PostMapping
    public OrderSummary placeOrder(@RequestBody OrderDto orderDto) {
        return orderService.placeOrder(orderDto);
    }

    @GetMapping("/initData")
    public InitOrder initData() {
        return InitOrder.builder()
                .shipment(shipmentService.getShipments())
                .build();
    }

}
