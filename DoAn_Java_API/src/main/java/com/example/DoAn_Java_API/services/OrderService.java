package com.example.DoAn_Java_API.services;

import com.example.DoAn_Java_API.model.Category;
import com.example.DoAn_Java_API.model.KhachHang;
import com.example.DoAn_Java_API.model.Order;
import com.example.DoAn_Java_API.model.User;
import com.example.DoAn_Java_API.modelDto.OrderDto;
import com.example.DoAn_Java_API.repository.ICategoryRepository;
import com.example.DoAn_Java_API.repository.IOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class OrderService {
    @Autowired
    private IOrderRepository orderRepository;
    @Autowired
    private CustomerService customerService;
    @Autowired
    private UserService userService;
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    public Order getOrderById(int id) {
        Optional<Order> optional = orderRepository.findById(id);
        return optional.orElse(null);
    }

    public Order addOrder(OrderDto orderDto) {
        KhachHang khachHang= customerService.getById(orderDto.getCustomer_id());
        if(khachHang==null){
             User user=userService.getUserByUserName(orderDto.getUsername());
             if(user!=null){
                 khachHang= customerService.getByUser_id(user.getId());
             }
        }
        LocalDate currentDate = LocalDate.now();
        LocalTime currentTime = LocalTime.now();
        Date date= java.sql.Timestamp.valueOf(currentDate.atTime(currentTime));

        Order order= new Order(
                orderDto.getId(),
                date,
                orderDto.getTotal(),
                khachHang,
                null
        );
        orderRepository.save(order);
        return order;
    }

//    public void updateCategory(Category category) {
//        categoryRepository.save(category);
//    }
//
//    public boolean deleteCategory(Long id) {
//        Optional<Category> optional = categoryRepository.findById(id);
//        if (optional.isPresent()) {
//            categoryRepository.delete(optional.get());
//            return true;
//        }
//        return false;
//    }
}
