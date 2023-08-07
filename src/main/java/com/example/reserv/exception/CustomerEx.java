package com.example.reserv.exception;

import lombok.Getter;


    @Getter
    public class CustomerEx extends RuntimeException {

        private final ErrorCode errorCode;

        public CustomerEx(ErrorCode errorCode) {
            super(errorCode.getDetail());
            this.errorCode = errorCode;
        }

}
