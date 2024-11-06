package com.example.technogiseorderservice.model;

import jakarta.persistence.Embeddable;

@Embeddable
public class OrderItem {
    private Long foodItemId; // ID of the food item
    private int quantity; // Quantity ordered

    public Long getFoodItemId() {
        return foodItemId;
    }

    public void setFoodItemId(Long foodItemId) {
        this.foodItemId = foodItemId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
