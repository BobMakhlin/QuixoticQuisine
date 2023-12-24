package com.quixoticquisine.orderservice.api;

import com.quixoticquisine.orderservice.model.AddOrder;
import com.quixoticquisine.orderservice.model.Order;
import com.quixoticquisine.orderservice.service.OrderService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.HttpStatus.OK;

@RestController
@AllArgsConstructor
public class OrdersApiController {
    private final OrderService orderService;

    @PostMapping("/orders")
    ResponseEntity<Order> addOrder(@RequestBody AddOrder addOrder) {
        var order = orderService.createOrder(addOrder);
        return new ResponseEntity<>(order,
                OK);
    }
}
