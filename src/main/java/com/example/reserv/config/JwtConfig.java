package com.example.reserv.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

public class JwtConfig {

    @Configuration
    public class JwtConfig {


        @Bean
        public JwtAuthenticationProvider jwtAuthenticationProvider() {
            return new JwtAuthenticationProvider();
        }
    }
}

