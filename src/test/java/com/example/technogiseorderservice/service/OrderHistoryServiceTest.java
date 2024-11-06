package com.example.technogiseorderservice.service;


import com.example.technogiseorderservice.model.OrderHistory;
import com.example.technogiseorderservice.model.OrderStatus;
import com.example.technogiseorderservice.repository.OrderHistoryRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class OrderHistoryServiceTest {

    @Mock
    private OrderHistoryRepository orderHistoryRepository;

    @InjectMocks
    private OrderHistoryService orderHistoryService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testAddOrderHistory() {
        OrderHistory orderHistory = new OrderHistory(1L, OrderStatus.PROCESSING, LocalDateTime.now(), "system");
        when(orderHistoryRepository.save(orderHistory)).thenReturn(orderHistory);

        OrderHistory savedOrderHistory = orderHistoryService.addOrderHistory(orderHistory);

        assertNotNull(savedOrderHistory);
        assertEquals(OrderStatus.PROCESSING, savedOrderHistory.getStatus());
        verify(orderHistoryRepository, times(1)).save(orderHistory);
    }

    @Test
    void testGetOrderHistoryByOrderId() {
        Long orderId = 1L;
        List<OrderHistory> historyList = Arrays.asList(
                new OrderHistory(orderId, OrderStatus.PROCESSING, LocalDateTime.now(), "system"),
                new OrderHistory(orderId, OrderStatus.SHIPPED, LocalDateTime.now().plusHours(1), "user")
        );
        when(orderHistoryRepository.findByOrderId(orderId)).thenReturn(historyList);

        List<OrderHistory> result = orderHistoryService.getOrderHistoryByOrderId(orderId);

        assertEquals(2, result.size());
        assertEquals(OrderStatus.PROCESSING, result.get(0).getStatus());
        verify(orderHistoryRepository, times(1)).findByOrderId(orderId);
    }

    @Test
    void testGetOrderHistoryById() {
        Long id = 1L;
        OrderHistory orderHistory = new OrderHistory(id, OrderStatus.DELIVERED, LocalDateTime.now(), "system");
        when(orderHistoryRepository.findById(id)).thenReturn(Optional.of(orderHistory));

        Optional<OrderHistory> result = orderHistoryService.getOrderHistoryById(id);

        assertTrue(result.isPresent());
        assertEquals(OrderStatus.DELIVERED, result.get().getStatus());
        verify(orderHistoryRepository, times(1)).findById(id);
    }
}
