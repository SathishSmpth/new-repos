package com.kamatchibotique.application.service;


import com.kamatchibotique.application.entity.order.Order;

import java.util.List;

public interface OrderService {
    Order createOrder(Order order);

    List<Order> getAllOrder();

    Order getAOrder(long id);

    Order updateAOrder(long id, Order order);
}
