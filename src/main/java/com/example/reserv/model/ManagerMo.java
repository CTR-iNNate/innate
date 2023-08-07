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
    public class ManagerMo  {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "manager_id")
        private Long id;

        private String email;
        private String name;
        private String password;
        private String phone;


        @OneToOne(cascade = CascadeType.ALL)
        @JoinColumn(name = "shop_id")
        private Shop shop;

        public static ManagerMo from(SignUpForm form) {
            return ManagerMo.builder()
                    .email(form.getEmail())
                    .name(form.getName())
                    .password(form.getPassword())
                    .phone(form.getPhone())
                    .build();
        }

        public void setShop(Shop shop) {
            this.shop = shop;

            if (shop.getManager() != this) {
                shop.setManager(this);
            }
        }

        public boolean hasShop() {
            if (this.shop == null) {
                return false;
            } else {
                return true;
            }
}
