package com.example.onlineshopbackend.order.model.dto;


import com.example.onlineshopbackend.order.model.Shipment;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
public class InitOrder {
    private List<Shipment> shipment;
}
