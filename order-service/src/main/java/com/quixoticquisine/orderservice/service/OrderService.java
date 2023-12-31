package com.quixoticquisine.orderservice.service;

import com.quixoticquisine.orderservice.model.AddOrder;
import com.quixoticquisine.orderservice.model.Order;

import java.util.UUID;

public interface OrderService {
    Order createOrder(AddOrder addOrder);

    void rejectOrder(UUID orderId);
}
