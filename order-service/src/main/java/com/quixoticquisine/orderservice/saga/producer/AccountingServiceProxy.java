package com.quixoticquisine.orderservice.saga.producer;

import com.quixoticquisine.commoneventuatekit.AuthorizeCardCommand;
import io.eventuate.tram.commands.common.Success;
import io.eventuate.tram.sagas.simpledsl.CommandEndpoint;
import io.eventuate.tram.sagas.simpledsl.CommandEndpointBuilder;
import org.springframework.stereotype.Component;

@Component
class AccountingServiceProxy {
    public final CommandEndpoint<AuthorizeCardCommand> authorizeCard = CommandEndpointBuilder
            .forCommand(AuthorizeCardCommand.class)
            .withChannel("accountingService")
            .withReply(Success.class)
            .build();
}
