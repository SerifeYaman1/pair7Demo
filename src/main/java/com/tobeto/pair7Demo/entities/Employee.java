package com.tobeto.pair7Demo.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Table(name="employees")
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Employee {
    @Column(name="id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="title")
    private String title;

    @Column(name="birth_date")
    private LocalDate birthDate;

    @Column(name="hire_date")
    private LocalDate hireDate;

    @Column(name="photo_url")
    private String photoUrl;

    @OneToMany(mappedBy = "employee")
    private List<Order> orders;

    @OneToOne(mappedBy = "employee")
    private User user;
}
