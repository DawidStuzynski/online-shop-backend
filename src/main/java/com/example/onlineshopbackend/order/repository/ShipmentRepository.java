package com.example.onlineshopbackend.order.repository;

import com.example.onlineshopbackend.order.model.Shipment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShipmentRepository extends JpaRepository<Shipment, Long> {

}
