package com.example.Do_An_Java_Layout.controller.error;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller

public class CustomErrorController implements ErrorController {
    @GetMapping @RequestMapping("/error")
    public  String handleError(HttpServletRequest request){
        Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
        if(status!=null){
            int statusCode= Integer.parseInt(status.toString());
            if(statusCode==404) return "error";
        }
        return null;
    }
    @PostMapping("/403")
    public  String handleErrorDeniedAccess(){
        return "403";
    }
}
