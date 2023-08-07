package com.example.reserv.dto;


import com.example.reserv.model.Shop;
import lombok.*;

    @Getter
    @ToString
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public class ShopDto {
        private Long id;
        private String name;
        private String description;
        private String address;

        public static ShopDto from(Shop shop) {
            return ShopDto.builder()
                    .id(shop.getId())
                    .name(shop.getName())
                    .description(shop.getDescription())
                    .address(shop.getAddress())
                    .build();
        }
}
