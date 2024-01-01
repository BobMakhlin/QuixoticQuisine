package com.quixoticquisine.accountingservice.saga.consumer;

import io.eventuate.tram.sagas.participant.SagaCommandDispatcher;
import io.eventuate.tram.sagas.participant.SagaCommandDispatcherFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AccountingCommandHandlerConfig {
    @Bean
    public SagaCommandDispatcher accountingCommandHandlersDispatcher(AccountingCommandHandler accountingCommandHandler,
                                                                  SagaCommandDispatcherFactory sagaCommandDispatcherFactory) {
        return sagaCommandDispatcherFactory.make("accountingService", accountingCommandHandler.commandHandlers());
    }
}
