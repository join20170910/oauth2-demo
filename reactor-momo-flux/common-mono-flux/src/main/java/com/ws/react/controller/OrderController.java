package com.ws.react.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import com.ws.react.entity.Order;
import com.ws.react.service.OrderService;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * @ClassName OrderController
 * @Deacription TODO
 * @Author apple
 * @Date 2020/8/29 14:10
 * @Version 1.0
 **/
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping("v1/orders")
    public Flux<Order> getOrderList() {

        Flux<Order> orders = orderService.getOrdersFallback();
        return orders;
    }
    @GetMapping("vi/orders/{id}")
    public Mono<Order> getOrder(@PathVariable String id ){
        Mono<Order> order = orderService.getOrderById(id);
         return order;
    }
}
