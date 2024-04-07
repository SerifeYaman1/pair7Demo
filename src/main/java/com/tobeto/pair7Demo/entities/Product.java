package com.tobeto.pair7Demo.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Table(name="products")
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    @Column(name="id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="name")
    private String name;

    @Column(name="description")
    private String description;

    @Column(name="unit_price")
    private double unitPrice;

    @Column(name="is_active")
    private boolean isActive;

    @Column(name="units_in_stock")
    private int unitsInStock;

    @OneToMany(mappedBy = "product")
    private List<Image> images;

    @OneToMany(mappedBy ="product")
    private List<ProductSupplier> productSuppliers;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    @ManyToMany(mappedBy="products")
    private List<OrderDetail> orderDetails;
}
