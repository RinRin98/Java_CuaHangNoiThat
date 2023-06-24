package com.example.DoAn_Java_API.services;

import com.example.DoAn_Java_API.jwt.JwtGeneratorInterface;
import com.example.DoAn_Java_API.model.User;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.TimeZone;

@Service
public class JwtGeneratorImpl implements JwtGeneratorInterface {
    @Value("${jwt.secret}")
    private String secret;

    @Value("${jwt.expiration}")
    private int expirationTimeInSeconds;

    @Value("${app.jwttoken.message}")
    private String message;

    @Override
    public Map<String, String> generateToken(User user) {
        Date now = new Date();
        Date expirationDate = new Date(now.getTime() + (expirationTimeInSeconds * 1000));

        Claims claims = Jwts.claims().setSubject(user.getUsername());
        // Thêm các thông tin khác vào claims nếu cần
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX");
        dateFormat.setTimeZone(TimeZone.getTimeZone("Asia/Ho_Chi_Minh"));
        String expirationDateStr = dateFormat.format(expirationDate);

        String token = Jwts.builder()
                .setClaims(claims)
                .setIssuedAt(now)
                .setExpiration(expirationDate)
                .signWith(SignatureAlgorithm.HS256, secret)
                .compact();

        Map<String, String> response = new HashMap<>();
        response.put("token", token);
        response.put("message", message);
        return response;
    }
    public Map<String, Object> decodeToken(String token) {
        Claims claims = Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();

        Map<String, Object> decodedToken = new HashMap<>();
        decodedToken.put("username", claims.getSubject());
        // Thêm các thông tin khác từ claims vào decodedToken nếu cần

        return decodedToken;
    }
}
