package com.quixoticquisine.orderservice.saga.consumer;

import com.quixoticquisine.commoneventuatekit.RejectOrderCommand;
import com.quixoticquisine.orderservice.service.OrderService;
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
public class OrderCommandHandler {
    private final OrderService orderService;

    public CommandHandlers commandHandlers() {
        return SagaCommandHandlersBuilder
                .fromChannel("orderService")
                .onMessage(RejectOrderCommand.class, this::rejectOrder)
                .build();
    }

    public Message rejectOrder(CommandMessage<RejectOrderCommand> commandMessage) {
        log.info("rejectOrder {}", commandMessage.getCommand());

        try {
            orderService.rejectOrder(commandMessage.getCommand().getOrderId());
            return withSuccess();
        } catch (IllegalArgumentException ex) {
            return withFailure();
        }
    }
}
