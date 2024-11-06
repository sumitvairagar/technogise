package com.example.technogiseorderservice.service;

import com.example.technogiseorderservice.model.Order;
import com.example.technogiseorderservice.model.OrderStatus;
import com.example.technogiseorderservice.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    // Create a new order
    public Order createOrder(Order order) {
        order.setOrderDate(LocalDateTime.now());
        order.setStatus(OrderStatus.PENDING);
        order.setTotalAmount(calculateTotalAmount(order));
        return orderRepository.save(order);
    }

    // Calculate total amount based on order items
    private Double calculateTotalAmount(Order order) {
        return order.getItems().stream()
                .mapToDouble(item -> getItemPrice(item.getFoodItemId()) * item.getQuantity())
                .sum();
    }

    // Mock method to retrieve item price
    private Double getItemPrice(Long foodItemId) {
        // Assume each item costs $10.0 for simplicity
        return 10.0;
    }

    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }
}
