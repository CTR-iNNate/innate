package com.example.reserv.model;

import com.example.reserv.form.SignUpForm;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;



    @Entity
    @Getter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public class CustomerMo {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "customer_id")
        private Long id;

        private String email;
        private String name;
        private String password;
        private String phone;

        public static CustomerMo from(SignUpForm form) {
            return CustomerMo.builder()
                    .email(form.getEmail())
                    .name(form.getName())
                    .password(form.getPassword())
                    .phone(form.getPhone())
                    .build();
        }
}
