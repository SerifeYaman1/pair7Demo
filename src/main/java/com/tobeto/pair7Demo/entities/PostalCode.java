package com.tobeto.pair7Demo.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Table(name="postal_codes")
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PostalCode {
    @Column(name="id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="code")
    private int code;

    @OneToMany(mappedBy = "postalCode")
    private List<Address> addresses;
}
