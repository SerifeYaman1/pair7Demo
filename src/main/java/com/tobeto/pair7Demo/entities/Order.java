package com.tobeto.pair7Demo.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Table(name="orders")
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Order {
    @Column(name="id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="order_date")
    private LocalDateTime orderDate;

    @Column(name="delivery_date")
    private LocalDateTime deliveryDate;

    @Column(name="required_date")
    private LocalDate requiredDate;

    @Column(name="shipped_date")
    private LocalDateTime shippedDate;

    @OneToOne(mappedBy = "order")
    private OrderDetail orderDetail;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;

    @OneToOne(mappedBy = "order")
    private Payment payment;
}
