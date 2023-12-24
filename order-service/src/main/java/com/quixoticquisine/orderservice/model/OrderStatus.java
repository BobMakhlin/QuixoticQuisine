package com.quixoticquisine.orderservice.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum OrderStatus {
    PENDING_APPROVAL("PENDING_APPROVAL");

    private final String name;
}
