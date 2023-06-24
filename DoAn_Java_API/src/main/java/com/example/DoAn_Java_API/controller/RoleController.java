package com.example.DoAn_Java_API.controller;

import com.example.DoAn_Java_API.model.Category;
import com.example.DoAn_Java_API.model.Role;
import com.example.DoAn_Java_API.repository.IRoleRepository;
import com.example.DoAn_Java_API.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:9998")
@RequestMapping("/roles")
public class RoleController {
    @Autowired
    private IRoleRepository roleRepository;

    @GetMapping
    public List<Role> getAll() {
        return roleRepository.findAll();
    }
}
