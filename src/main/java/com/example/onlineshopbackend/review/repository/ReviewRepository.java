package com.example.onlineshopbackend.review.repository;

import com.example.onlineshopbackend.common.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {
}
