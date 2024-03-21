package com.tobeto.pair7Demo.entities;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Table(name="cities")
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "customer_city")
    private String customerCity;

    @Column(name = "supplier_city")
    private String supplierCity;

    @OneToMany(mappedBy = "city")
    private List<Address> addresses;
    @ManyToOne
    @JoinColumn(name = "country_id")
    private Country country;

}
