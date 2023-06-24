package com.example.Do_An_Java_Layout.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/cart")
public class CartController {
    @GetMapping("")
    String cart(){
        return "cart/cart";
    }
    @GetMapping("/checkout")
    String checkout(){
        return "cart/checkout";
    }

}
