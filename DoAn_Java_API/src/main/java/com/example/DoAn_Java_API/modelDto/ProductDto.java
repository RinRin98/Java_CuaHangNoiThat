package com.example.DoAn_Java_API.modelDto;

import com.example.DoAn_Java_API.model.Category;
import com.example.DoAn_Java_API.model.ImagesDetail;
import com.example.DoAn_Java_API.model.OrderDetail;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;


@Getter @Setter
public class ProductDto {
    private  Long id;
    private  String name;
    private String title;
    private Long Price;
    private Long SoLuong;
    private Long category_id;
}
