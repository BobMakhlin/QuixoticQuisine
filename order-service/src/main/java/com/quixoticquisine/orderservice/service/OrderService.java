package com.quixoticquisine.orderservice.service;

import com.quixoticquisine.orderservice.model.AddOrder;
import com.quixoticquisine.orderservice.model.Order;

import java.util.UUID;

public interface OrderService {
    Order createOrder(AddOrder addOrder);

    /**
     * Rejects an order.
     *
     * @throws com.quixoticquisine.common.exception.ItemNotFoundException If an order with the specified id was not found.
     */
    void rejectOrder(UUID orderId);

    /**
     * Approves an order.
     *
     * @throws com.quixoticquisine.common.exception.ItemNotFoundException If an order with the specified id was not found.
     */
    void approveOrder(UUID orderId);
}
