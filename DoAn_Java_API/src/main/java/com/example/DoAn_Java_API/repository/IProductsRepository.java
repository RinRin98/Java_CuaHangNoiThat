package com.example.DoAn_Java_API.repository;

import com.example.DoAn_Java_API.model.ImagesDetail;
import com.example.DoAn_Java_API.model.Products;
import com.example.DoAn_Java_API.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IProductsRepository extends JpaRepository<Products, Long> {
    @Query("SELECT p FROM Products p WHERE p.category.id = ?1")
    List<Products> findByCategoryId(Long categoryId);
}