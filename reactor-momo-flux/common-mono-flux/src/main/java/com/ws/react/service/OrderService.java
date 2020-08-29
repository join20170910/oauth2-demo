package com.ws.react.service;


import org.springframework.stereotype.Component;
import com.ws.react.entity.Order;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @ClassName OrderService
 * @Deacription TODO
 * @Author apple
 * @Date 2020/8/29 14:06
 * @Version 1.0
 **/

@Component
public class OrderService {

    public Flux<Order> getOrdersFallback(){

        List<Order> fallbacklist = new ArrayList<>();
        Order order = new Order();
        order.setId("OrderInvalidId");
        order.setAccountId("InvalidId");
        order.setItem("Order list is not  available");
        order.setCreateTime(new Date());
        fallbacklist.add(order);

        return Flux.fromIterable(fallbacklist);
    }

    public Mono<Order> getOrderFallback(){

        Order order = new Order();
        order.setId("OrderInvalidId");
        order.setAccountId("InvalidId");
        order.setItem("Order list is not  available");
        order.setCreateTime(new Date());

        return Mono.just(order);
    }


    public Mono<Order> getOrderById(String id) {

        Order order = new Order();
        order.setId("OrderInvalidId");
        order.setAccountId("InvalidId");
        order.setItem("Order list is not  available");
        order.setCreateTime(new Date());
        return Mono.just(order);
    }
}
