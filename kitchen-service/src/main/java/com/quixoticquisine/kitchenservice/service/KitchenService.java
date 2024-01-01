package com.quixoticquisine.kitchenservice.service;

import com.quixoticquisine.commoneventuatekit.CreateTicketCommand;

import java.util.UUID;

public interface KitchenService {
    /**
     * Creates a ticket.
     *
     * @return ID of the created ticket.
     */
    UUID createTicket(CreateTicketCommand createTicketCommand);

    void rejectTicket(UUID ticketId);
}
