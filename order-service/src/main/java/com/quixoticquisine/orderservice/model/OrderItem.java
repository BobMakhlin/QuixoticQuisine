package com.quixoticquisine.orderservice.model;

import lombok.Data;

import java.util.UUID;

@Data
public class OrderItem {
    private UUID productId;
    private Integer amount;
}
