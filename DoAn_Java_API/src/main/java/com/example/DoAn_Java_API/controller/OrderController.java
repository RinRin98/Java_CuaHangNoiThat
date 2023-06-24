package com.example.DoAn_Java_API.controller;

import com.example.DoAn_Java_API.model.Category;
import com.example.DoAn_Java_API.model.Order;
import com.example.DoAn_Java_API.modelDto.OrderDto;
import com.example.DoAn_Java_API.services.CategoryService;
import com.example.DoAn_Java_API.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:9998")
@RequestMapping("/orders")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @GetMapping
    public List<Order> getAllOrders() {
        return orderService.getAllOrders();
    }


    @PostMapping
    public Order createOrder(@RequestBody OrderDto orderDto) {
        return orderService.addOrder(orderDto);
    }

}
