package com.example.DoAn_Java_API.modelDto;

import com.example.DoAn_Java_API.model.Products;
import jakarta.persistence.*;
import lombok.*;


@Getter @Setter
public class ImageDto {
    private int id;
    private String image;
    private Long product_id;
}