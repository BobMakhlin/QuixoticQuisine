package com.quixoticquisine.orderservice.saga.producer;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class CreateOrderSagaData {
    private UUID consumerId;
    private UUID orderId;
}
