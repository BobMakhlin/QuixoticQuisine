package com.quixoticquisine.orderservice.service;

import com.quixoticquisine.commoneventuatekit.RejectOrderCommand;
import com.quixoticquisine.commoneventuatekit.ValidateConsumerCommand;
import com.quixoticquisine.orderservice.domain.OrderEntity;
import com.quixoticquisine.orderservice.domain.OrderItemEntity;
import com.quixoticquisine.orderservice.model.AddOrder;
import com.quixoticquisine.orderservice.model.OrderItem;
import com.quixoticquisine.orderservice.saga.producer.CreateOrderSagaData;
import org.mapstruct.CollectionMappingStrategy;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring",
        collectionMappingStrategy = CollectionMappingStrategy.TARGET_IMMUTABLE,
        injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface OrderMapper {
    @Mapping(target = ".", source = "orderDetails")
    OrderEntity addOrderToOrderEntity(AddOrder order);

    OrderItemEntity orderItemToOrderItemEntity(OrderItem orderItem);

    CreateOrderSagaData addOrderToCreateOrderSagaData(AddOrder order);

    ValidateConsumerCommand createOrderSagaDataToValidateConsumerCommand(CreateOrderSagaData data);

    RejectOrderCommand createOrderSagaDataToRejectOrderCommand(CreateOrderSagaData data);
}
