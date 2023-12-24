package com.quixoticquisine.orderservice.service;

import com.quixoticquisine.orderservice.domain.OrderEntity;
import com.quixoticquisine.orderservice.domain.OrderItemEntity;
import com.quixoticquisine.orderservice.model.AddOrder;
import com.quixoticquisine.orderservice.model.OrderItem;
import org.mapstruct.CollectionMappingStrategy;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring",
        collectionMappingStrategy = CollectionMappingStrategy.TARGET_IMMUTABLE,
        injectionStrategy = InjectionStrategy.CONSTRUCTOR)
interface OrderMapper {
    @Mapping(target = ".", source = "orderDetails")
    OrderEntity addOrderToOrderEntity(AddOrder order);

    OrderItemEntity orderItemToOrderItemEntity(OrderItem orderItem);
}
