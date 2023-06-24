package com.example.DoAn_Java_API.repository;

import com.example.DoAn_Java_API.model.Category;
import com.example.DoAn_Java_API.model.ChucVu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IChucVuRepository extends JpaRepository<ChucVu, Long> {
}