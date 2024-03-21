package com.tobeto.pair7Demo.entities;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name="postal_codes")
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Postal {
    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "customer_code")
    private String customerCode;
    @Column(name = "supplier_code")
    private String supplierCode;
}
