package com.quixoticquisine.consumerservice.service;

import java.util.UUID;

public interface ConsumerService {
    boolean canCreateOrder(UUID consumerId);
}
