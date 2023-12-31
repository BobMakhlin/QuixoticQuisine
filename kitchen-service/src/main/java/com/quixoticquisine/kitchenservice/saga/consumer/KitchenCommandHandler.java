package com.quixoticquisine.kitchenservice.saga.consumer;

import com.quixoticquisine.commoneventuatekit.CreateTicketCommand;
import com.quixoticquisine.commoneventuatekit.CreateTicketReply;
import com.quixoticquisine.kitchenservice.service.KitchenService;
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
public class KitchenCommandHandler {
    private final KitchenService kitchenService;

    public CommandHandlers commandHandlers() {
        return SagaCommandHandlersBuilder
                .fromChannel("kitchenService")
                .onMessage(CreateTicketCommand.class, this::createTicket)
                .build();
    }

    public Message createTicket(CommandMessage<CreateTicketCommand> commandMessage) {
        log.info("createTicket, orderId: {}", commandMessage.getCommand().getOrderId());

        try {
            var id = kitchenService.createTicket(commandMessage.getCommand());
            return withSuccess(new CreateTicketReply(id));
        } catch (RuntimeException ex) {
            log.error("error", ex);
            return withFailure();
        }
    }
}
