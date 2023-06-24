package com.example.DoAn_Java_API.controller;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.TimeZone;

@RestController
@RequestMapping("/api/v1/token")
public class TokenController {

    @Value("${jwt.secret}")
    private String secret;

    @GetMapping("/expiration")
    public ResponseEntity<Map<String, Object>> checkTokenExpiration(HttpServletRequest request) {
        String token = extractTokenFromHeader(request);
        if (token == null) {
            // Token is missing or invalid
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }

        Claims claims = Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
        Date expirationDate = claims.getExpiration();

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX");
        dateFormat.setTimeZone(TimeZone.getTimeZone("Asia/Ho_Chi_Minh"));
        String expirationDateStr = dateFormat.format(expirationDate);

        Map<String, Object> response = new HashMap<>();
        response.put("expirationDate", expirationDateStr);

        return ResponseEntity.ok(response);
    }





    private String extractTokenFromHeader(HttpServletRequest request) {
        String headerValue = request.getHeader("Authorization");
        if (headerValue != null && headerValue.startsWith("Bearer ")) {
            return headerValue.substring(7);
        }
        return null;
    }
}

