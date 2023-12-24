package com.quixoticquisine.orderservice.service;

import com.quixoticquisine.orderservice.model.AddOrder;
import com.quixoticquisine.orderservice.model.Order;

public interface OrderService {
    Order createOrder(AddOrder addOrder);
}
