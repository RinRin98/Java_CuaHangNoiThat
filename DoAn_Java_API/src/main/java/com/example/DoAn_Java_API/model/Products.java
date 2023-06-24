package com.example.DoAn_Java_API.model;

import com.example.DoAn_Java_API.services.CategoryService;
import com.example.DoAn_Java_API.services.ProductService;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Data
@Entity
@Table(name="Products")
@AllArgsConstructor
@NoArgsConstructor
public class Products {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;

    @Column(name = "name")
//    @NotEmpty(message = "Title must not be empty")
//    @Size(max = 50, min = 1, message = "Title must be less than 50 characters")
    private  String name;

    @Column(name = "title")
    private String title;


    @Column(name = "price")
    private Long Price;

    @Column(name = "soluong")
    private Long SoLuong;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    @JsonIgnore
    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    private List<OrderDetail> orderDetails;

    @JsonIgnore
    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    private List<ImagesDetail> imagesDetails;
}
