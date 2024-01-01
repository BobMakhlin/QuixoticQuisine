package com.quixoticquisine.accountingservice.saga.consumer;

import com.quixoticquisine.commoneventuatekit.AuthorizeCardCommand;
import io.eventuate.tram.commands.consumer.CommandHandlers;
import io.eventuate.tram.commands.consumer.CommandMessage;
import io.eventuate.tram.messaging.common.Message;
import io.eventuate.tram.sagas.participant.SagaCommandHandlersBuilder;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import static io.eventuate.tram.commands.consumer.CommandHandlerReplyBuilder.withSuccess;

@Slf4j
@Service
@RequiredArgsConstructor
public class AccountingCommandHandler {
    public CommandHandlers commandHandlers() {
        return SagaCommandHandlersBuilder
                .fromChannel("accountingService")
                .onMessage(AuthorizeCardCommand.class, this::authorizeCard)
                .build();
    }

    public Message authorizeCard(CommandMessage<AuthorizeCardCommand> commandMessage) {
        log.info("authorizeCard: {}", commandMessage.getCommand());

        return withSuccess();
    }
}
