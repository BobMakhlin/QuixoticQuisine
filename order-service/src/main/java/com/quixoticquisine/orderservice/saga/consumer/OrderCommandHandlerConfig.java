package com.quixoticquisine.orderservice.saga.consumer;

import io.eventuate.tram.sagas.participant.SagaCommandDispatcher;
import io.eventuate.tram.sagas.participant.SagaCommandDispatcherFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OrderCommandHandlerConfig {
    @Bean
    public SagaCommandDispatcher orderCommandHandlersDispatcher(OrderCommandHandler orderCommandHandler,
                                                                SagaCommandDispatcherFactory sagaCommandDispatcherFactory) {
        return sagaCommandDispatcherFactory.make("orderService", orderCommandHandler.commandHandlers());
    }
}
