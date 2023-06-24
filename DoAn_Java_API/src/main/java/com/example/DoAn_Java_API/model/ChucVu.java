package com.example.DoAn_Java_API.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "ChucVu")
public class ChucVu {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCV;

    @Column(name = "TenCV")
    private String TenCV;

    @JsonIgnore
    @OneToMany(mappedBy = "chucVu", cascade = CascadeType.ALL)
    private List<NhanVien> nhanViens;
}

