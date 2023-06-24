package com.example.DoAn_Java_API.modelDto;

import com.example.DoAn_Java_API.model.KhachHang;
import com.example.DoAn_Java_API.model.OrderDetail;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;
@Getter @Setter
public class OrderDto {

    private int id;
    private int customer_id;
    private long total;
    private String username;

}