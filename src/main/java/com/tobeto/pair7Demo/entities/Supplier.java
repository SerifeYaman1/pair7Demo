package com.tobeto.pair7Demo.entities;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Table(name="suppliers")
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Supplier {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "company_name")
    private String companyName;
    @Column(name = "contact_name")
    private String contactName;

    @OneToMany(mappedBy = "address")
    private List<Address> address ;

    @OneToMany(mappedBy = "customer")
    private List<Contact> contact ;

    @OneToMany(mappedBy = "supplier")
    private List<InformationsPayment> info ;
}
