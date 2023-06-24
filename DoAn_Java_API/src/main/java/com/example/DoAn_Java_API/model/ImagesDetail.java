package com.example.DoAn_Java_API.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "images_detail")
@AllArgsConstructor
@NoArgsConstructor
public class ImagesDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "image")
    private String image;


    @ManyToOne
    @JoinColumn(name = "product_id")
    private Products product;
}