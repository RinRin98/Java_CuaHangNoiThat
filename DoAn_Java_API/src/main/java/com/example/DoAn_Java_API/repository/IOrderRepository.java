package com.example.DoAn_Java_API.repository;

import com.example.DoAn_Java_API.model.Order;
import com.example.DoAn_Java_API.model.Products;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IOrderRepository extends JpaRepository<Order, Integer> {

}