package com.quixoticquisine.orderservice.service;

import com.quixoticquisine.orderservice.domain.OrderStatusEnum;
import com.quixoticquisine.orderservice.model.AddOrder;
import com.quixoticquisine.orderservice.model.Order;
import com.quixoticquisine.orderservice.model.OrderStatus;
import com.quixoticquisine.orderservice.repository.OrderRepository;
import com.quixoticquisine.orderservice.saga.producer.CreateOrderSaga;
import io.eventuate.tram.sagas.orchestration.SagaInstanceFactory;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@AllArgsConstructor
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;
    private final OrderMapper orderMapper;
    private final SagaInstanceFactory sagaInstanceFactory;
    private final CreateOrderSaga createOrderSaga;

    @Transactional
    @Override
    public Order createOrder(AddOrder addOrder) {
        var orderEntity = orderMapper.addOrderToOrderEntity(addOrder);
        orderEntity.setOrderStatus(OrderStatusEnum.PENDING_APPROVAL);
        var savedOrderEntity = orderRepository.saveAndFlush(orderEntity);

        var sagaData = orderMapper.addOrderToCreateOrderSagaData(addOrder);
        sagaData.setOrderId(savedOrderEntity.getId());
        sagaInstanceFactory.create(createOrderSaga, sagaData);

        return Order.builder().status(OrderStatus.PENDING_APPROVAL)
                .id(savedOrderEntity.getId()).build();
    }

    @Transactional
    @Override
    public void rejectOrder(UUID orderId) {
        var orderEntity = orderRepository.findById(orderId)
                .orElseThrow(IllegalArgumentException::new); // todo throw notfoundexception
        orderEntity.setOrderStatus(OrderStatusEnum.REJECTED);
        orderRepository.saveAndFlush(orderEntity);
    }
}
