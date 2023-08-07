package com.example.reserv.repository;

import com.example.reserv.model.Shop;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ShopRepository extends JpaRepository<Shop, Long> {

    Optional<Shop> findByManagerId(Long managerId);

    Optional<Shop> findByName(String name);

}