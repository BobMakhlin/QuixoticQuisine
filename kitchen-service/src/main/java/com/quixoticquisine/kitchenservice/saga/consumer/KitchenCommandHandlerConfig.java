package com.quixoticquisine.kitchenservice.saga.consumer;

import io.eventuate.tram.sagas.participant.SagaCommandDispatcher;
import io.eventuate.tram.sagas.participant.SagaCommandDispatcherFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class KitchenCommandHandlerConfig {
    @Bean
    public SagaCommandDispatcher kitchenCommandHandlersDispatcher(KitchenCommandHandler kitchenCommandHandler,
                                                                  SagaCommandDispatcherFactory sagaCommandDispatcherFactory) {
        return sagaCommandDispatcherFactory.make("kitchenService", kitchenCommandHandler.commandHandlers());
    }
}
