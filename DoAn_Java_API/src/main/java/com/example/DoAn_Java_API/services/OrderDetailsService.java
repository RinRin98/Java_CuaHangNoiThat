package com.example.DoAn_Java_API.services;

import com.example.DoAn_Java_API.model.Order;
import com.example.DoAn_Java_API.model.OrderDetail;
import com.example.DoAn_Java_API.model.Products;
import com.example.DoAn_Java_API.modelDto.OrderDetailDto;
import com.example.DoAn_Java_API.repository.IOrderDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderDetailsService {
    @Autowired
    private IOrderDetailsRepository orderDetailsRepository;
    @Autowired
    private ProductService productService;
    @Autowired
    private  OrderService orderService;
    public List<OrderDetail> getAll()
    {
        return orderDetailsRepository.findAll();
    }
    public List<OrderDetail> getOrderDetailByOrderId(int order_id){return orderDetailsRepository.findByOrderId(order_id);}
    public OrderDetail getProductById(int id){
        Optional<OrderDetail> optional = orderDetailsRepository.findById(id);
        return optional.orElse(null);
    }

    public OrderDetail addOrderDetail(OrderDetailDto orderDetailDto){
        Products products= productService.getProductById(orderDetailDto.getProduct_id());
        Order order= orderService.getOrderById(orderDetailDto.getOrder_id());

        OrderDetail orderDetail = new OrderDetail(
                orderDetailDto.getId(),
                orderDetailDto.getQuantity(),
                products.getPrice()*orderDetailDto.getQuantity(),
                order,
                products
        );
        orderDetailsRepository.save(orderDetail);
        return orderDetail;
    }

    public void delete(int id){
        orderDetailsRepository.deleteById(id);
    }


}
