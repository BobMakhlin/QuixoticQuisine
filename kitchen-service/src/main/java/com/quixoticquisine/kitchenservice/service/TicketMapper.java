package com.quixoticquisine.kitchenservice.service;

import com.quixoticquisine.commoneventuatekit.CreateTicketCommand;
import com.quixoticquisine.kitchenservice.domain.TicketEntity;
import com.quixoticquisine.kitchenservice.domain.TicketItemEntity;
import org.mapstruct.CollectionMappingStrategy;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;
import java.util.Set;

@Mapper(componentModel = "spring",
        collectionMappingStrategy = CollectionMappingStrategy.TARGET_IMMUTABLE,
        injectionStrategy = InjectionStrategy.CONSTRUCTOR)
interface TicketMapper {
    @Mapping(target = "ticketItems", source = "orderItems")
    TicketEntity createTicketCommandToTicketEntity(CreateTicketCommand command);

    Set<TicketItemEntity> orderItemsToTicketItems(List<CreateTicketCommand.TicketItem> orderItems);
}
