package com.example.reserv.contorller;

import com.example.reserv.form.AddShopForm;
import com.example.reserv.service.ManagerService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;p

    @RestController
    @RequestMapping("/manager")
    @RequiredArgsConstructor
    public class ManagerCon {

        private final ManagerService managerService;




        @PostMapping("/shop")
        public ResponseEntity<String> addShop(
                @RequestHeader(name = TOKEN_NAME) String token,
                @RequestBody @Valid AddShopForm form) {

            return ResponseEntity.ok(managerService.addShop(vo.getId(), form));
        }






        }


}
