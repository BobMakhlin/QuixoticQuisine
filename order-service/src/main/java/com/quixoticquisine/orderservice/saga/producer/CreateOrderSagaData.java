package com.quixoticquisine.orderservice.saga.producer;

import com.quixoticquisine.commoneventuatekit.CreateTicketReply;
import com.quixoticquisine.orderservice.model.OrderItem;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
public class CreateOrderSagaData {
    private UUID consumerId;
    private UUID orderId;
    private UUID restaurantId;
    private UUID ticketId;
    private List<OrderItem> orderItems;

    public void handleCreateTicketReply(CreateTicketReply createTicketReply) {
        ticketId = createTicketReply.getTicketId();
    }
}
