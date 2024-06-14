package com.kamatchibotique.application.service.impl;

import com.kamatchibotique.application.entity.order.Order;
import com.kamatchibotique.application.exception.ServiceException;
import com.kamatchibotique.application.repository.OrderRepository;
import com.kamatchibotique.application.service.OrderService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Override
    public Order createOrder(Order order) {
        return orderRepository.save(order);
    }

    @Override
    public Order getAOrder(long id) {
        return orderRepository.findById(id).orElseThrow(() -> new ServiceException(HttpStatus.NOT_FOUND, "Order is not found!"));
    }

    @Override
    public List<Order> getAllOrder() {
        return orderRepository.findAll();
    }

    @Override
    public Order updateAOrder(long id, Order order) {
        Order updateOrder = orderRepository.findById(id)
                .orElseThrow(() -> new ServiceException(HttpStatus.NOT_FOUND, "Order is not found!"));

        updateOrder.setOrderDate(order.getOrderDate());
        updateOrder.setOrderTotal(order.getOrderTotal());
        updateOrder.setPaymentMethods(order.getPaymentMethods());
        updateOrder.setBillingAddress(order.getBillingAddress());
        updateOrder.setShippingAddress(order.getShippingAddress());
        return orderRepository.save(updateOrder);
    }

}
