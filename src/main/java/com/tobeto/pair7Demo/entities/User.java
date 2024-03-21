package com.tobeto.pair7Demo.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Table(name="users")
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class User {
    @Column(name="id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name="e_first_name")
    private String eFirstName;
    @Column(name="e_last_name")
    private String eLastName;
    @Column(name="c_first_name")
    private String cFirstName;
    @Column(name="c_last_name")
    private String cLastName;
    @OneToOne
    @JoinColumn(name="contact_id")
    private Contact contact;
    @OneToMany(mappedBy = "user")
    private List<Address> address;
    @OneToOne
    @JoinColumn(name="images_id")
    private Image images;
}




