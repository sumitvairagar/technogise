package com.example.technogiseorderservice.repository;

import com.example.technogiseorderservice.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {
    List<Order> findByUserId(Long userId); // Find orders by user ID
    List<Order> findByRestaurantId(Long restaurantId); // Find orders by restaurant ID
    List<Order> findByStatus(String status); // Find orders by status
}
