package com.example.reserv.dto;


import lombok.*;

@Getter
    @ToString
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public class TokenDto {
    private String token;

    public static TokenDto from(String token) {
        return TokenDto.builder()
                .token(token)
                .build();
    }
}
