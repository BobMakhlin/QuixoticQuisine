package com.quixoticquisine.consumerservice.service;

import com.quixoticquisine.consumerservice.repository.ConsumerRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Slf4j
@Service
@AllArgsConstructor
public class ConsumerServiceImpl implements ConsumerService {
    private final ConsumerRepository consumerRepository;

    @Override
    public boolean canCreateOrder(UUID consumerId) {
        var consumerOptional = consumerRepository.findById(consumerId);
        if (consumerOptional.isEmpty()) {
            log.error("Consumer {} not found", consumerId);
            return false;
        }
        if (!consumerOptional.get().isActive()) {
            log.error("Consumer {} not active", consumerId);
            return false;
        }
        return true;
    }
}
