package com.quixoticquisine.orderservice.model;

import lombok.Data;

import java.util.List;
import java.util.UUID;

@Data
public class AddOrderDetails {
    private UUID restaurantId;
    private List<OrderItem> orderItems;
}
