package com.quixoticquisine.consumerservice.saga;

import io.eventuate.tram.sagas.participant.SagaCommandDispatcher;
import io.eventuate.tram.sagas.participant.SagaCommandDispatcherFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConsumerCommandHandlerConfig {
    @Bean
    public SagaCommandDispatcher orderCommandHandlersDispatcher(ConsumerCommandHandler consumerCommandHandler,
                                                                SagaCommandDispatcherFactory sagaCommandDispatcherFactory) {
        return sagaCommandDispatcherFactory.make("consumerService", consumerCommandHandler.commandHandlers());
    }
}
