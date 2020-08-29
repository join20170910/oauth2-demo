package com.ws.react.inter;

import com.ws.react.entity.Order;
import reactor.core.publisher.Flux;

public interface OrderRepository {
    // List<Order> getOrders();
    // Page<Order> getOrders(Pageable page);
    Flux<Order> getOrders();
}
