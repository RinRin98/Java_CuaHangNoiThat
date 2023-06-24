package com.example.Do_An_Java_Layout.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/admin/nhanvien")
public class AdminNhanVienController {
    @GetMapping("/list")
    String list(){
        return "admin/nhanvien/list";
    }

    @GetMapping("/add")
    String add(){
        return "admin/nhanvien/add";
    }
    @GetMapping("/detail/{id}")
    String detail(@RequestParam Long id){
        return "admin/products/detail";
    }


}
