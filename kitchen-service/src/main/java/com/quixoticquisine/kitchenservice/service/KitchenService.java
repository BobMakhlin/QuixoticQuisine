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

    /**
     * Rejects a ticket.
     *
     * @throws com.quixoticquisine.common.exception.ItemNotFoundException If a ticket with the specified id was not found.
     */
    void rejectTicket(UUID ticketId);

    /**
     * Approves a ticket.
     *
     * @throws com.quixoticquisine.common.exception.ItemNotFoundException If a ticket with the specified id was not found.
     */
    void approveTicket(UUID ticketId);
}
