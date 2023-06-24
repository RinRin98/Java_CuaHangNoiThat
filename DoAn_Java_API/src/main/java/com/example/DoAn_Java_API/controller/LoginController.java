package com.example.DoAn_Java_API.controller;

import com.example.DoAn_Java_API.config.AuthenticationConfig;
import com.example.DoAn_Java_API.jwt.UserNotFoundException;
import com.example.DoAn_Java_API.repository.IUserRepository;
import com.example.DoAn_Java_API.services.CustomUserDetailService;
import com.example.DoAn_Java_API.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;


@RestController
@RequestMapping("")
@CrossOrigin(origins = "http://localhost:9998")
public class LoginController {

    @Autowired
    private UserService userService;
    @Autowired
    private CustomUserDetailService customUserDetailService;
    @Autowired
    private IUserRepository userRepository;
    @Autowired
    AuthenticationConfig AuthenticationConfig;
    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestParam String username, @RequestParam String password) {
        try {
            var customUserDetail= customUserDetailService.loadUserByUsername(username);
            Authentication authentication = new UsernamePasswordAuthenticationToken(customUserDetail,password,customUserDetail.getAuthorities());
            AuthenticationConfig.AUTHENTICATION=authentication;
             String message=authentication.getAuthorities().toString();
            Map<String, String> response = new HashMap<>();
            response.put("message", message);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (UserNotFoundException e) {
            Map<String, String> response = new HashMap<>();
            response.put("error", "Lỗi: " + e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.CONFLICT);
        }
    }


}
