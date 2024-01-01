package com.quixoticquisine.commoneventuatekit;

import io.eventuate.tram.commands.common.Command;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class AuthorizeCardCommand implements Command {
    private UUID consumerId;
    private UUID ticketId;
    private UUID orderId;
}
