package com.quixoticquisine.orderservice.service;

import com.quixoticquisine.commoneventuatekit.*;
import com.quixoticquisine.orderservice.domain.OrderEntity;
import com.quixoticquisine.orderservice.domain.OrderItemEntity;
import com.quixoticquisine.orderservice.model.AddOrder;
import com.quixoticquisine.orderservice.model.OrderItem;
import com.quixoticquisine.orderservice.saga.producer.CreateOrderSagaData;
import org.mapstruct.CollectionMappingStrategy;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring",
        collectionMappingStrategy = CollectionMappingStrategy.TARGET_IMMUTABLE,
        injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface OrderMapper {
    @Mapping(target = ".", source = "orderDetails")
    OrderEntity addOrderToOrderEntity(AddOrder order);

    OrderItemEntity orderItemToOrderItemEntity(OrderItem orderItem);

    @Mapping(target = ".", source = "orderDetails")
    CreateOrderSagaData addOrderToCreateOrderSagaData(AddOrder order);

    ValidateConsumerCommand createOrderSagaDataToValidateConsumerCommand(CreateOrderSagaData data);

    RejectOrderCommand createOrderSagaDataToRejectOrderCommand(CreateOrderSagaData data);

    CreateTicketCommand createOrderSagaDataToCreateTicketCommand(CreateOrderSagaData data);

    List<CreateTicketCommand.TicketItem> orderItemsToTicketItems(List<OrderItem> orderItems);

    RejectTicketCommand createOrderSagaDataToRejectTicketCommand(CreateOrderSagaData createOrderSagaData);

    AuthorizeCardCommand createOrderSagaDataToAuthorizeCardCommand(CreateOrderSagaData createOrderSagaData);

    ApproveTicketCommand createOrderSagaDataToApproveTicketCommand(CreateOrderSagaData createOrderSagaData);
}
