package com.example.reserv.service;

import com.example.reserv.config.JwtAuthenticationProvider;
import com.example.reserv.exception.CustomerEx;
import com.example.reserv.exception.ErrorCode;
import com.example.reserv.form.SignInForm;
import com.example.reserv.model.CustomerMo;
import com.example.reserv.model.ManagerMo;
import com.example.reserv.repository.CustomerRepository;
import com.example.reserv.repository.ManagerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.example.reserv.util.PasswordUtil;

@Service
@RequiredArgsConstructor
public class SignInService {

    private final ManagerRepository managerRepository;
    private final CustomerRepository customerRepository;
    private final JwtAuthenticationProvider provider;


    public String managerSignIn(SignInForm form) {
        ManagerMo m = managerRepository.findByEmail(form.getEmail())
                .orElseThrow(() -> new CustomerEx(ErrorCode.NOT_FOUND_MANAGER));


        if (!PasswordUtil.checkPassword(form.getPassword(), m.getPassword())) {
            throw new CustomerEx(ErrorCode.WRONG_PASSWORD);
        }




        }


    }
}

