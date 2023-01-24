package com.example.onlineshopbackend.review.controller;

import com.example.onlineshopbackend.review.dto.ReviewDto;
import com.example.onlineshopbackend.review.model.Review;
import com.example.onlineshopbackend.review.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/reviews")
public class ReviewController {

    private final ReviewService reviewService;

    @PostMapping("/review")
    public Review addReview(@RequestBody ReviewDto reviewDto) {
        return reviewService.addReview(Review.builder()
                .authorName(reviewDto.authorName())
                .productId(reviewDto.productId())
                .content(reviewDto.content())
                .build());
    }
}
