package com.example.reserv.contorller;

import com.example.reserv.form.SignUpForm;
import jakarta.validation.Valid;
import lombok.*;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static sun.security.util.KeyUtil.validate;

@RestController
@RequestMapping("/signUp")
@RequiredArgsConstructor
public class SignUpCon {

    private final SignUpService signUpService;

    // 매니저 회원가입
    @PostMapping("/manager")
    public ResponseEntity<Object> signUpManger(@RequestBody @Valid SignUpForm form, Errors errors) {

        // 유효성 검사에서 발생한 에러 메세지 모음
        if (errors.hasErrors()) {
            validate(errors);
        }

        form.encryptPassword(form.getPassword());

        return ResponseEntity.ok(signUpService.managerSignUp(form));
    }
}
