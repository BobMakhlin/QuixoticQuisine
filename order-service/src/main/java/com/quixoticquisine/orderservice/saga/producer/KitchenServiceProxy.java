package com.quixoticquisine.orderservice.saga.producer;

import com.quixoticquisine.commoneventuatekit.CreateTicketCommand;
import com.quixoticquisine.commoneventuatekit.CreateTicketReply;
import io.eventuate.tram.sagas.simpledsl.CommandEndpoint;
import io.eventuate.tram.sagas.simpledsl.CommandEndpointBuilder;
import org.springframework.stereotype.Component;

@Component
class KitchenServiceProxy {
    public final CommandEndpoint<CreateTicketCommand> createTicket = CommandEndpointBuilder
            .forCommand(CreateTicketCommand.class)
            .withChannel("kitchenService")
            .withReply(CreateTicketReply.class)
            .build();
}
