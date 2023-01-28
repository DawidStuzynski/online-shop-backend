package com.example.onlineshopbackend.common.repository;

import com.example.onlineshopbackend.common.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {
    List<Review> findAllByProductIdAndModerated(Long productId, boolean moderated);
}
