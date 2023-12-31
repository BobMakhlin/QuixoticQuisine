package com.quixoticquisine.commoneventuatekit;


import io.eventuate.tram.commands.common.Command;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CreateTicketCommand implements Command {
    private UUID consumerId;
    private UUID orderId;
    private UUID restaurantId;
    private List<TicketItem> orderItems;

    @Setter
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class TicketItem {
        private UUID productId;
        private Integer amount;
    }
}
