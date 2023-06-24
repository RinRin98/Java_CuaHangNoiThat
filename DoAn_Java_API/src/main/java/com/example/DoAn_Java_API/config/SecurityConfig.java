package com.example.DoAn_Java_API.config;

import com.example.DoAn_Java_API.jwt.JwtFilter;
import com.example.DoAn_Java_API.services.CustomUserDetailService;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Bean
    public UserDetailsService userDetailsService() {
        return new CustomUserDetailService();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public FilterRegistrationBean jwtFilter() {
        FilterRegistrationBean filter= new FilterRegistrationBean();
        filter.setFilter(new JwtFilter());
        // provide endpoints which needs to be restricted.
        // All Endpoints would be restricted if unspecified
        filter.addUrlPatterns("/api/v1/blog/restricted");
        return filter;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
                .csrf().disable()
                .authorizeRequests(auth -> auth
                        .requestMatchers("/api/v1/user/login", "/api/v1/user/login/google/callback")
                        .permitAll()
                        .requestMatchers("/products/edit", "/products/delete", "/products/add")
                        .hasAnyAuthority("ADMIN")
                        .requestMatchers("/products/home")
                                .permitAll()
//                        .hasAnyAuthority("ADMIN", "USER")
                        .requestMatchers("/api/v1/user/**")
                        .permitAll()
                        .anyRequest().permitAll()
                )
                .oauth2Login(oauth2 -> oauth2
                        .defaultSuccessUrl("/api/v1/user/login/google/callback")
                        .loginPage("/api/v1/user/login")
                        .loginProcessingUrl("/login/oauth2/code/google"))
                // Các cấu hình khác...
                .build();
    }


}
