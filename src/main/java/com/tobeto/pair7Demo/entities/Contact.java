package com.tobeto.pair7Demo.entities;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name="contacts")
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Contact {
    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "sup_phone")
    private String supPhone;
    @Column(name = "cus_phone")
    private String cusPhone;
    @Column(name = "sup_mail")
    private String supMail;
    @Column(name = "cus_mail")
    private String cusMail;
    @Column(name = "e_phone")
    private String ePhone;
    @Column(name = "e_mail")
    private String eMail;
    @OneToOne(mappedBy = "contact")
    private User user;

}
