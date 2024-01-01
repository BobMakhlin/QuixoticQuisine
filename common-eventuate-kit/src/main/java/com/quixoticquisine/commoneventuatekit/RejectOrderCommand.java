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
public class RejectOrderCommand implements Command {
    private UUID orderId;
}
