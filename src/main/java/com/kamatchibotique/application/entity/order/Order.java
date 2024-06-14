package com.kamatchibotique.application.entity.order;

import java.util.List;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long orderId;

    @Column(name = "orderedBy")
    private String orderedBy;

    @OneToMany
    private List<OrderSummary> orderSummary;

    @Column(name = "orderDate")
    private String orderDate;

    @Column(name = "orderTotal")
    private String orderTotal;

    @Column(name = "paymentMethods")
    private String paymentMethods;

    @Column(name = "billingAddress")
    private String billingAddress;

    @Column(name = "shippingAddress")
    private String shippingAddress;

    @Column(name = "totalAmount")
    private double totalAmount;
}
