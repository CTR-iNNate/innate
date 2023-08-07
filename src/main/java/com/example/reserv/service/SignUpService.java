package com.example.reserv.service;

import com.example.reserv.exception.CustomerEx;
import com.example.reserv.exception.ErrorCode;
import com.example.reserv.form.SignUpForm;
import com.example.reserv.model.ManagerMo;
import com.example.reserv.repository.CustomerRepository;
import com.example.reserv.repository.ManagerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SignUpService {

    private final ManagerRepository managerRepository;
    private final CustomerRepository customerRepository;

  
    public String managerSignUp(SignUpForm form) {
        if (isEmailExistManager(form.getEmail())) {
            throw new CustomerEx(ErrorCode.ALREADY_REGISTERED_USER);
        }

        managerRepository.save(ManagerMo.from(form));

        return "회원가입이 완료되었습니다.";
    }

  
    private boolean isEmailExistManager(String email) {
        return managerRepository.findByEmail(email).isPresent();
    }
