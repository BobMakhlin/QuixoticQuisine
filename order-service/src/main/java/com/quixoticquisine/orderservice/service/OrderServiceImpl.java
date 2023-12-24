package com.quixoticquisine.orderservice.service;

import com.quixoticquisine.orderservice.domain.OrderStatusEnum;
import com.quixoticquisine.orderservice.model.AddOrder;
import com.quixoticquisine.orderservice.model.Order;
import com.quixoticquisine.orderservice.model.OrderStatus;
import com.quixoticquisine.orderservice.repository.OrderRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;
    private final OrderMapper orderMapper;

    @Transactional
    @Override
    public Order createOrder(AddOrder addOrder) {
        var orderEntity = orderMapper.addOrderToOrderEntity(addOrder);
        orderEntity.setOrderStatus(OrderStatusEnum.PENDING_APPROVAL);
        var savedOrderEntity = orderRepository.saveAndFlush(orderEntity);

        return Order.builder().status(OrderStatus.PENDING_APPROVAL)
                .id(savedOrderEntity.getId()).build();
    }
}
