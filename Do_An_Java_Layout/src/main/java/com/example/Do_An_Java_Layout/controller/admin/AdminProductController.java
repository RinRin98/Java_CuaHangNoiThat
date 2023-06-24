package com.example.Do_An_Java_Layout.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/admin/products")
public class AdminProductController {
    @GetMapping("/list")
    String list(){
        return "admin/products/list";
    }

    @GetMapping("/add")
    String add(){
        return "admin/products/add";
    }
    @GetMapping("/detail")
    String detail(@RequestParam Long id){
        return "admin/products/detail";
    }


}
