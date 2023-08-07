package com.example.reserv.model;


import jakarta.persistence.*;
import lombok.*;

@Entity
    @Getter
    @Setter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public class Shop  {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "shop_id")
        private Long id;

        private String name;
        private String description;
        private String address;
        private int tableCount;



        @OneToOne(mappedBy = "shop")
        private ManagerMo manager;





}
