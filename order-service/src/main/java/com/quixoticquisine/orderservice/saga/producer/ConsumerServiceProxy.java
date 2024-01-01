package com.quixoticquisine.orderservice.saga.producer;

import com.quixoticquisine.commoneventuatekit.ValidateConsumerCommand;
import io.eventuate.tram.commands.common.Success;
import io.eventuate.tram.sagas.simpledsl.CommandEndpoint;
import io.eventuate.tram.sagas.simpledsl.CommandEndpointBuilder;
import org.springframework.stereotype.Component;

@Component
class ConsumerServiceProxy {
    public final CommandEndpoint<ValidateConsumerCommand> validateConsumer = CommandEndpointBuilder
            .forCommand(ValidateConsumerCommand.class)
            .withChannel("consumerService")
            .withReply(Success.class)
            .build();
}
