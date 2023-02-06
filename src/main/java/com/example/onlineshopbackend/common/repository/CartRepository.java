package com.example.onlineshopbackend.common.repository;

import com.example.onlineshopbackend.common.model.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface CartRepository extends JpaRepository<Cart, Long> {
    List<Cart> findByCreatedLessThan(LocalDateTime minusDays);

    @Query("delete from Cart c where c.id=:id")
    @Modifying
    void deleteCartById(Long id);


    @Query("delete from Cart c where c.id in (:ids)")
    @Modifying
    void deleteAllByIdIn(List<Long> ids);
}
