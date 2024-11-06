package com.example.technogiseorderservice.service;

import com.example.technogiseorderservice.model.OrderHistory;
import com.example.technogiseorderservice.repository.OrderHistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderHistoryService {

    private final OrderHistoryRepository orderHistoryRepository;

    @Autowired
    public OrderHistoryService(OrderHistoryRepository orderHistoryRepository) {
        this.orderHistoryRepository = orderHistoryRepository;
    }

    // Method to add an order history entry
    public OrderHistory addOrderHistory(OrderHistory orderHistory) {
        return orderHistoryRepository.save(orderHistory);
    }

    // Method to get all history entries for a specific order
    public List<OrderHistory> getOrderHistoryByOrderId(Long orderId) {
        return orderHistoryRepository.findByOrderId(orderId);
    }

    // Method to get a specific order history entry by ID
    public Optional<OrderHistory> getOrderHistoryById(Long id) {
        return orderHistoryRepository.findById(id);
    }
}
