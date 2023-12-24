package com.quixoticquisine.orderservice.api;

import com.quixoticquisine.orderservice.model.AddOrder;
import com.quixoticquisine.orderservice.model.Order;
import com.quixoticquisine.orderservice.model.OrderStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.HttpStatus.OK;

@RestController
public class OrdersApiController {
    @PostMapping("/orders")
    ResponseEntity<Order> addOrder(@RequestBody AddOrder addOrder) {
        return new ResponseEntity<>(Order.builder()
                .status(OrderStatus.PENDING_APPROVAL).build(),
                OK);
    }
}
