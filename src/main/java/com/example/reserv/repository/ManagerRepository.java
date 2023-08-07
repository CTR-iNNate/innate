package com.example.reserv.repository;

import com.example.reserv.model.ManagerMo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ManagerRepository extends JpaRepository<ManagerMo, Long> {

    Optional<ManagerMo> findByEmail(String email);

    Optional<ManagerMo> findByIdAndEmail(Long id, String email);