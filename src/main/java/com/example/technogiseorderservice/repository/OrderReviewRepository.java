package com.example.technogiseorderservice.repository;

import com.example.technogiseorderservice.model.OrderReview;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderReviewRepository extends JpaRepository<OrderReview, Long> {
}
