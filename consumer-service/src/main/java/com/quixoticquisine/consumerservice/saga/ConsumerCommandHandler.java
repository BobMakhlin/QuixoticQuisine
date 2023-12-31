package com.quixoticquisine.consumerservice.saga;

import com.quixoticquisine.commoneventuatekit.ValidateConsumerCommand;
import com.quixoticquisine.consumerservice.service.ConsumerService;
import io.eventuate.tram.commands.consumer.CommandHandlers;
import io.eventuate.tram.commands.consumer.CommandMessage;
import io.eventuate.tram.messaging.common.Message;
import io.eventuate.tram.sagas.participant.SagaCommandHandlersBuilder;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import static io.eventuate.tram.commands.consumer.CommandHandlerReplyBuilder.withFailure;
import static io.eventuate.tram.commands.consumer.CommandHandlerReplyBuilder.withSuccess;

@Slf4j
@Service
@RequiredArgsConstructor
public class ConsumerCommandHandler {
    private final ConsumerService consumerService;

    public CommandHandlers commandHandlers() {
        return SagaCommandHandlersBuilder
                .fromChannel("consumerService")
                .onMessage(ValidateConsumerCommand.class, this::validateConsumer)
                .build();
    }

    public Message validateConsumer(CommandMessage<ValidateConsumerCommand> commandMessage) {
        log.info("validateConsumer {}", commandMessage.getCommand());

        if (consumerService.canCreateOrder(commandMessage.getCommand().getConsumerId())) {
            return withSuccess();
        }
        return withFailure();
    }
}
