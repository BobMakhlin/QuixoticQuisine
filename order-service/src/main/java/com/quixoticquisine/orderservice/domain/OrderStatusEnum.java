package com.quixoticquisine.orderservice.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum OrderStatusEnum {
    PENDING_APPROVAL("PENDING_APPROVAL"),
    APPROVED("APPROVED"),
    CANCELLED("CANCELLED"),
    REJECTED("REJECTED");

    private final String name;
}
