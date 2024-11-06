package com.example.technogiseorderservice.service;

import com.example.technogiseorderservice.model.Order;
import com.example.technogiseorderservice.model.OrderItem;
import com.example.technogiseorderservice.repository.OrderRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.junit.jupiter.api.extension.ExtendWith;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class OrderServiceTest {

    @InjectMocks
    private OrderService orderService;

    @Mock
    private OrderRepository orderRepository;

    @Test
    public void testCreateOrder() {
        Order order = new Order();
        OrderItem item1 = new OrderItem();
        item1.setFoodItemId(1L);
        item1.setQuantity(2);

        order.setItems(Arrays.asList(item1));
        order.setUserId(1L);
        order.setRestaurantId(1L);

        when(orderRepository.save(order)).thenReturn(order);

        Order createdOrder = orderService.createOrder(order);
        assertEquals("Pending", createdOrder.getStatus());
        assertEquals(20.0, createdOrder.getTotalAmount());
    }
}

