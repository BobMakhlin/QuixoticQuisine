package com.quixoticquisine.kitchenservice.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum TicketStatusEnum {
    PENDING_APPROVAL("PENDING_APPROVAL"),
    REJECTED("REJECTED"),
    APPROVED("APPROVED");

    private final String name;
}
