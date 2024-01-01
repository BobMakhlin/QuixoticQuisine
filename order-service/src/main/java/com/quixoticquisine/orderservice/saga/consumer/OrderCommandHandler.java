package com.quixoticquisine.orderservice.saga.consumer;

import com.quixoticquisine.commoneventuatekit.ApproveOrderCommand;
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
                .onMessage(ApproveOrderCommand.class, this::approveOrder)
                .build();
    }

    public Message rejectOrder(CommandMessage<RejectOrderCommand> commandMessage) {
        log.info("rejectOrder, orderId: {}", commandMessage.getCommand().getOrderId());

        try {
            orderService.rejectOrder(commandMessage.getCommand().getOrderId());
            return withSuccess();
        } catch (RuntimeException ex) {
            return withFailure();
        }
    }

    private Message approveOrder(CommandMessage<ApproveOrderCommand> commandMessage) {
        log.info("approveOrder, orderId: {}", commandMessage.getCommand().getOrderId());

        try {
            orderService.approveOrder(commandMessage.getCommand().getOrderId());
            return withSuccess();
        } catch (RuntimeException ex) {
            return withFailure();
        }
    }
}
