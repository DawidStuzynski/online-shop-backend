package com.example.onlineshopbackend.order.repository;

import com.example.onlineshopbackend.order.model.OrderRow;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRowRepository extends JpaRepository<OrderRow, Long> {
}
