package com.example.DoAn_Java_API.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Time;

@Data
@Entity
@Table(name="KhachHang")
@AllArgsConstructor
@NoArgsConstructor
public class KhachHang {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idKh;

    @Column(name = "Hoten")
//    @NotEmpty(message = "Title must not be empty")
//    @Size(max = 50, min = 1, message = "Title must be less than 50 characters")
    private  String Hoten;

    @Column(name = "SDT")
//    @NotEmpty(message = "Title must not be empty")
//    @Size(max = 50, min = 1, message = "Title must be less than 50 characters")
    private  String SDT;

    @Column(name = "Email")
//    @NotEmpty(message = "Title must not be empty")
//    @Size(max = 50, min = 1, message = "Title must be less than 50 characters")
    private  String Email;

    @Column(name = "DiaChi")
//    @NotEmpty(message = "Title must not be empty")
//    @Size(max = 50, min = 1, message = "Title must be less than 50 characters")
    private  String DiaChi;

    @Column(name = "NgaySinh")
//    @NotEmpty(message = "Title must not be empty")
//    @Size(max = 50, min = 1, message = "Title must be less than 50 characters")
    private Time NgaySinh;

    @Column(name = "GioiTinh")
//    @NotEmpty(message = "Title must not be empty")
//    @Size(max = 50, min = 1, message = "Title must be less than 50 characters")
    private  Boolean GioiTinh;

    @OneToOne
    @JoinColumn(name = "idUser")
    private User user;
}

