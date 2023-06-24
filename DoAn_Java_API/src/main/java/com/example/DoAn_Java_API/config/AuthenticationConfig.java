package com.example.DoAn_Java_API.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.Authentication;

@Configuration
public class AuthenticationConfig {

   @Autowired
    public static Authentication AUTHENTICATION;
}

