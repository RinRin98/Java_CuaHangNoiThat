package com.example.DoAn_Java_API.repository;

import com.example.DoAn_Java_API.model.OrderDetail;
import com.example.DoAn_Java_API.model.Products;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IOrderDetailsRepository extends JpaRepository<OrderDetail, Integer> {
    @Query("SELECT p FROM OrderDetail p WHERE p.order.id = ?1")
    List<OrderDetail> findByOrderId(int orderId);
}