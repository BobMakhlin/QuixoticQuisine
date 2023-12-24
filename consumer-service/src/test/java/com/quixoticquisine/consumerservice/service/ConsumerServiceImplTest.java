package com.quixoticquisine.consumerservice.service;

import com.quixoticquisine.consumerservice.domain.ConsumerEntity;
import com.quixoticquisine.consumerservice.repository.ConsumerRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;
import java.util.UUID;

@ExtendWith(MockitoExtension.class)
class ConsumerServiceImplTest {
    @InjectMocks
    ConsumerServiceImpl sut;
    @Mock
    ConsumerRepository consumerRepository;

    @Nested
    class CanCreateOrder {
        @Test
        void shouldReturnFalseIfConsumerNotFound() {
            // Arrange.
            var consumerId = UUID.fromString("ae9763dd-e55d-45da-8000-7afdf2837379");
            Mockito.when(consumerRepository.findById(consumerId))
                    .thenReturn(Optional.empty());
            // Act.
            var actual = sut.canCreateOrder(consumerId);
            // Assert.
            Assertions.assertFalse(actual);
        }

        @Test
        void shouldReturnFalseIfConsumerInactive() {
            // Arrange.
            var consumerId = UUID.fromString("ae9763dd-e55d-45da-8000-7afdf2837379");
            var consumer = new ConsumerEntity();
            consumer.setActive(false);
            Mockito.when(consumerRepository.findById(consumerId))
                    .thenReturn(Optional.of(consumer));
            // Act.
            var actual = sut.canCreateOrder(consumerId);
            // Assert.
            Assertions.assertFalse(actual);
        }

        @Test
        void shouldReturnTrueIfConsumerActive() {
            // Arrange.
            var consumerId = UUID.fromString("ae9763dd-e55d-45da-8000-7afdf2837379");
            var consumer = new ConsumerEntity();
            consumer.setActive(true);
            Mockito.when(consumerRepository.findById(consumerId))
                    .thenReturn(Optional.of(consumer));
            // Act.
            var actual = sut.canCreateOrder(consumerId);
            // Assert.
            Assertions.assertTrue(actual);
        }
    }
}
