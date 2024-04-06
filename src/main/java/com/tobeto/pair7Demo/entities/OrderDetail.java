package com.tobeto.pair7Demo.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Table(name="order_details")
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrderDetail {
    @Column(name="id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="unit_price")
    private double unitPrice;

    @Column(name="quantity")
    private int quantity;

    @OneToOne
    @JoinColumn(name = "payment_id")
    private Payment payment;

    @OneToOne
    @JoinColumn(name = "order_id")
    private Order order;

    @ManyToOne
    @JoinColumn(name = "address_id")
    private Address address;


    @ManyToMany
    @JoinTable(name="od_product",joinColumns =
    @JoinColumn(name="order_detail_id"), inverseJoinColumns =
    @JoinColumn(name="product_id"))
    private List<Product> products;
}
