package com.quixoticquisine.orderservice.model;

import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder
public class Order {
    private OrderStatus status;
    private UUID id;
}
