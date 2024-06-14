package com.kamatchibotique.application.repository;

import com.kamatchibotique.application.entity.order.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order,Long> {
}
