package com.quixoticquisine.kitchenservice.service;

import com.quixoticquisine.common.exception.ItemNotFoundException;
import com.quixoticquisine.commoneventuatekit.CreateTicketCommand;
import com.quixoticquisine.kitchenservice.domain.TicketStatusEnum;
import com.quixoticquisine.kitchenservice.repository.TicketRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class KitchenServiceImpl implements KitchenService {
    private final TicketMapper ticketMapper;
    private final TicketRepository ticketRepository;

    @Transactional
    @Override
    public UUID createTicket(CreateTicketCommand createTicketCommand) {
        var ticketEntity = ticketMapper.createTicketCommandToTicketEntity(createTicketCommand);
        ticketEntity.setTicketStatus(TicketStatusEnum.PENDING_APPROVAL);
        var savedEntity = ticketRepository.saveAndFlush(ticketEntity);
        return savedEntity.getId();
    }

    @Transactional
    @Override
    public void rejectTicket(UUID ticketId) {
        var ticketEntity = ticketRepository.findById(ticketId)
                .orElseThrow(() -> new ItemNotFoundException(ticketId));
        ticketEntity.setTicketStatus(TicketStatusEnum.REJECTED);
        ticketRepository.saveAndFlush(ticketEntity);
    }

    @Transactional
    @Override
    public void approveTicket(UUID ticketId) {
        var ticketEntity = ticketRepository.findById(ticketId)
                .orElseThrow(() -> new ItemNotFoundException(ticketId));
        ticketEntity.setTicketStatus(TicketStatusEnum.APPROVED);
        ticketRepository.saveAndFlush(ticketEntity);
    }
}
