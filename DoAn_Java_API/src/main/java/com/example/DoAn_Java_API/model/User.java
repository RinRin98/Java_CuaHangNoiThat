package com.example.DoAn_Java_API.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "username", length = 50, nullable = false, unique = true)
    private String username;

    @Column(name = "password", length = 250, nullable = false)
    private String password;

    @Column(name = "email", length = 50)
    private String email;

    @Column(name = "name", length = 50, nullable = false)
    private String name;


    @ManyToOne
    @JoinColumn(name = "idRole")
    private Role role;

    @JsonIgnore
    @OneToOne(mappedBy = "user")
    private NhanVien nhanVien;

    @JsonIgnore
    @OneToOne(mappedBy = "user")
    private KhachHang khachHang;
}
