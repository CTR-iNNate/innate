package com.example.reserv.repository;

import com.example.reserv.model.CustomerMo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CustomerRepository extends JpaRepository<CustomerMo, Long> {

    Optional<CustomerMo> findByEmail(String email);

    Optional<CustomerMo> findByAndEmail(Long id, String email);



}
