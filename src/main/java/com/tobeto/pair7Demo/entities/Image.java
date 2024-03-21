package com.tobeto.pair7Demo.entities;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name="images")
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Image {
    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "product_image")
    private String productImage;
    @Column(name = "category_image")
    private String categoryImage;
    @Column(name = "employee_photo")
    private String employeePhoto;
    @OneToOne(mappedBy = "imageId")
    private Category category;
}
