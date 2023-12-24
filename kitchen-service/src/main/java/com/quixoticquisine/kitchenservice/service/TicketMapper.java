package com.quixoticquisine.kitchenservice.service;

import org.mapstruct.CollectionMappingStrategy;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring",
        collectionMappingStrategy = CollectionMappingStrategy.TARGET_IMMUTABLE,
        injectionStrategy = InjectionStrategy.CONSTRUCTOR)
interface TicketMapper {

}
