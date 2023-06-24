package com.example.DoAn_Java_API.jwt;

import com.example.DoAn_Java_API.model.User;

import java.util.Map;

public interface JwtGeneratorInterface {
    Map<String, String> generateToken(User user);
    Map<String, Object> decodeToken(String token);

}
