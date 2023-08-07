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

   
    @PostMapping("/manager")
    public ResponseEntity<Object> signUpManger(@RequestBody @Valid SignUpForm form, Errors errors) {

        
        if (errors.hasErrors()) {
            validate(errors);
        }

        form.encryptPassword(form.getPassword());

        return ResponseEntity.ok(signUpService.managerSignUp(form));
    }
}
