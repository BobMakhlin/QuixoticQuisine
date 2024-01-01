package com.quixoticquisine.orderservice.saga.producer;

import com.quixoticquisine.commoneventuatekit.CreateTicketCommand;
import com.quixoticquisine.commoneventuatekit.CreateTicketReply;
import com.quixoticquisine.commoneventuatekit.RejectTicketCommand;
import io.eventuate.tram.commands.common.Success;
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
    public final CommandEndpoint<RejectTicketCommand> rejectTicket = CommandEndpointBuilder
            .forCommand(RejectTicketCommand.class)
            .withChannel("kitchenService")
            .withReply(Success.class)
            .build();
}
