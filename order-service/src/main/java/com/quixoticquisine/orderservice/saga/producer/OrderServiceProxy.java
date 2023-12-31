package com.quixoticquisine.orderservice.saga.producer;

import com.quixoticquisine.commoneventuatekit.RejectOrderCommand;
import io.eventuate.tram.commands.common.Success;
import io.eventuate.tram.sagas.simpledsl.CommandEndpoint;
import io.eventuate.tram.sagas.simpledsl.CommandEndpointBuilder;
import org.springframework.stereotype.Component;

@Component
class OrderServiceProxy {
    public final CommandEndpoint<RejectOrderCommand> rejectOrder = CommandEndpointBuilder
            .forCommand(RejectOrderCommand.class)
            .withChannel("orderService")
            .withReply(Success.class)
            .build();
}
