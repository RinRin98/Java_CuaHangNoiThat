package com.example.Do_An_Java_Layout.controller;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;

@Controller
@RequestMapping("")
public class HomeController {
    @GetMapping("/")
    String home(){
        return "home/index";
    }
    @GetMapping("/a")

    String home(@RequestParam(name = "token") String token, HttpSession session) {
        // Giải mã chuỗi token từ JSON

        try {

            session.setAttribute("token", token);

            return "home/index";

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @GetMapping("/sublayout/userinfo")
    String login_status(){
        return "sublayout/userinfo";
    }
    @GetMapping("/sublayout/user")
    String logout_status(){
        return "sublayout/user";
    }

    @GetMapping("/sublayout/forgotpass")
    String forgotpass_status(){
        return "sublayout/forgotpass";
    }
}
