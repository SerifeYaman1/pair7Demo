package com.tobeto.pair7Demo.entities;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Table(name="countries")
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Country {
    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "customer_country")
    private String customerCountry;
    @Column(name = "supplier_country")
    private String supplierCountry;
    @OneToMany (mappedBy = "country")
    private List<City> cityId;

}
