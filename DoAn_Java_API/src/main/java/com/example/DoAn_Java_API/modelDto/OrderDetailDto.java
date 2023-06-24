package com.example.DoAn_Java_API.modelDto;

import com.example.DoAn_Java_API.model.Order;
import com.example.DoAn_Java_API.model.Products;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class OrderDetailDto {
    private int id;
    private int quantity;
    private int order_id;
    private Long product_id;
}
