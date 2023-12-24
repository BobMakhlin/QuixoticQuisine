package com.quixoticquisine.orderservice.model;

import lombok.Data;

import java.util.UUID;

@Data
public class AddOrder {
    private UUID consumerId;
    private AddOrderDetails orderDetails;
}
