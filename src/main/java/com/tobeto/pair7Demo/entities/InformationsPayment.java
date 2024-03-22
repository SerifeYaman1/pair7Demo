package com.tobeto.pair7Demo.entities;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name="users")
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class InformationsPayment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "customer_card")
    private String customerCard;

    @Column(name = "supplier_card")
    private String supplierCard;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "supplier_id")
    private Supplier supplier;

}
