package com.example.reserv.contorller;

import com.example.reserv.dto.TokenDto;
import com.example.reserv.form.SignInForm;
import com.example.reserv.service.SignInService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

public class SignInCon {

    @RestController
    @RequestMapping("/signIn")
    @RequiredArgsConstructor
    public class SignInCon {

        private final SignInService signInService;

        @PostMapping("/manager")
        public ResponseEntity<TokenDto> mangerSignIn(@RequestBody SignInForm form) {
            return ResponseEntity.ok(TokenDto.from(signInService.managerSignIn(form)));
        }

        @PostMapping("/customer")
        public ResponseEntity<TokenDto> customerSignIn(@RequestBody SignInForm form) {
            return ResponseEntity.ok(TokenDto.from(signInService.customerSignIn(form)));
        }

    }
}
