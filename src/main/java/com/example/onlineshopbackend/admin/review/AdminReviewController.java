package com.example.onlineshopbackend.admin.review;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/admin/reviews")
public class AdminReviewController {
    private final AdminReviewService reviewService;
    @GetMapping
    public List<AdminReview> getReviews(){
        return reviewService.getReviews();
    }
    @PutMapping("/{id}/moderate")
    public void moderate(@PathVariable Long id){
        reviewService.moderate(id);
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        reviewService.delete(id);
    }
}