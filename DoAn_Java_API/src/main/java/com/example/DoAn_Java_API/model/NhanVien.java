package com.example.DoAn_Java_API.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name="NhanVien")
@AllArgsConstructor
@NoArgsConstructor
public class NhanVien {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long idNV;

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

    @Column(name = "GioiTinh")
    private  Boolean GioiTinh;

    @ManyToOne
    @JoinColumn(name = "idCv")
    private ChucVu chucVu;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

}

