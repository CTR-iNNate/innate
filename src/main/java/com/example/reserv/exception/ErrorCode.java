package com.example.reserv.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum ErrorCode {


    NOT_FOUND_MANAGER(HttpStatus.BAD_REQUEST, "존재하지 않는 매니저입니다."),
    NOT_FOUND_CUSTOMER(HttpStatus.BAD_REQUEST, "존재하지 않는 고객입니다."),
    WRONG_PASSWORD(HttpStatus.BAD_REQUEST, "올바른 비밀번호를 입력해주세요."),

    ALREADY_REGISTERED_USER(HttpStatus.BAD_REQUEST, "이미 가입된 회원입니다."),
    NOT_FOUND_SHOP(HttpStatus.BAD_REQUEST, "존재하지 않는 매장입니다."),
    ALREADY_SHOP_EXIST(HttpStatus.BAD_REQUEST, "이미 매장을 가지고 있는 매니저입니다.");


    private final HttpStatus httpStatus;
    private final String detail;



}
