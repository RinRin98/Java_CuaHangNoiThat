package com.example.Do_An_Java_Layout.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/admin/categories")
public class AdminCategoryController {
    @GetMapping("")
    String list(){
        return "admin/categories/categories";
    }
}
