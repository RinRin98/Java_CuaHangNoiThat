package com.example.DoAn_Java_API.repository;

import com.example.DoAn_Java_API.model.KhachHang;
import com.example.DoAn_Java_API.model.Products;
import com.example.DoAn_Java_API.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ICustomerRepository extends JpaRepository<KhachHang, Integer> {
    @Query("SELECT c FROM KhachHang c WHERE c.user.id = ?1")
    Optional<KhachHang> getByUser(Long userId);
}