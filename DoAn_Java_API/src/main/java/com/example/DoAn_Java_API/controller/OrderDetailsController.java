package com.example.DoAn_Java_API.controller;

import com.example.DoAn_Java_API.model.OrderDetail;
import com.example.DoAn_Java_API.modelDto.OrderDetailDto;
import com.example.DoAn_Java_API.services.OrderDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:9998")
@RequestMapping("/orderdetails")

public class OrderDetailsController {
    @Autowired
    private OrderDetailsService orderDetailsService;
    @GetMapping("")
    public List<OrderDetail> GetAll() {
        return orderDetailsService.getAll();
    }

    @GetMapping("/{id}")
    public OrderDetail get(@PathVariable int  id)
    {
        return orderDetailsService.getProductById(id);
    }
    @GetMapping("/findByCategory/{category_id}")
    public List<OrderDetail> findByCategory(@PathVariable int  order_id)
    {
        return orderDetailsService.getOrderDetailByOrderId(order_id);
    }
    @PostMapping("")
    public OrderDetail create(@RequestBody OrderDetailDto orderDetailDto)
    {
         return orderDetailsService.addOrderDetail(orderDetailDto);
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id)
    {
        orderDetailsService.delete(id);
    }
//    @PutMapping("/{id}")
//    public ResponseEntity<Products> update(@PathVariable int id, @RequestBody OrderDetail updatedProduct) {
//        OrderDetail existingProduct = orderDetailsService.getProductById(id);
//        if (existingProduct != null) {
//            updatedProduct.setId(id);
//            orderDetailsService.up(updatedProduct);
//            return ResponseEntity.ok(existingProduct);
//        } else {
//            return ResponseEntity.notFound().build();
//        }
//    }

}
