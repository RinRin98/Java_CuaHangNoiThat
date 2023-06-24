package com.example.DoAn_Java_API.repository;

import com.example.DoAn_Java_API.model.NhanVien;
import com.example.DoAn_Java_API.model.Products;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface INhanVienRepository extends JpaRepository<NhanVien, Long> {
    @Query("SELECT p FROM NhanVien p WHERE p.chucVu.idCV = ?1")
    List<NhanVien> findByChucVu(Long idCV);
}