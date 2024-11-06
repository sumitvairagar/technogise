package com.example.technogiseorderservice.model;


import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "order_review")
public class OrderReview {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "order_id", nullable = false)
    private Long orderId;

    @Column(name = "user_id", nullable = false)
    private Long userId;

    @Column(name = "rating", nullable = false)
    private Integer rating; // Rating out of 5

    @Column(name = "comments")
    private String comments;

    @Column(name = "review_date", nullable = false)
    private LocalDateTime reviewDate;

    public OrderReview() {
    }

    public OrderReview(Long orderId, Long userId, Integer rating, String comments, LocalDateTime reviewDate) {
        this.orderId = orderId;
        this.userId = userId;
        this.rating = rating;
        this.comments = comments;
        this.reviewDate = reviewDate;
    }

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public LocalDateTime getReviewDate() {
        return reviewDate;
    }

    public void setReviewDate(LocalDateTime reviewDate) {
        this.reviewDate = reviewDate;
    }
}

