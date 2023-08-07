package com.example.reserv.service;

import com.example.reserv.exception.CustomerEx;
import com.example.reserv.exception.ErrorCode;
import com.example.reserv.form.AddShopForm;
import com.example.reserv.model.ManagerMo;
import com.example.reserv.model.Shop;
import com.example.reserv.repository.ManagerRepository;
import com.example.reserv.repository.ShopRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.apache.commons.collections4.Trie;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Transactional
public class ManagerService {

    private final Trie trie;

    private final ShopRepository shopRepository;
    private final ManagerRepository managerRepository;




    public String addShop(Long managerId, AddShopForm form) {
        ManagerMo managermo = getManagerOrElseThrow(managerId);


        if (shopRepository.findByManagerId(managerId).isPresent()) {
            throw new CustomerEx(ErrorCode.ALREADY_SHOP_EXIST);
        }

        Shop shop = createAndSetShop(form, managermo);


        addAutocompleteKeyword(shop.getName());

        return "매장 등록이 완료되었습니다.";
    }

    private Shop createAndSetShop(AddShopForm form, ManagerMo manager) {

        Shop shop = Shop.builder()
                .name(form.getName())
                .description(form.getDescription())
                .address(form.getAddress())
                .tableCount(form.getTableCount())
                .build();
        manager.setShop(shop);

        managerRepository.save(manager);
        return shop;
    }

    private ManagerMo getManagerOrElseThrow(Long managerId) {
        return managerRepository.findById(managerId)
                .orElseThrow(() -> new CustomerEx(ErrorCode.NOT_FOUND_MANAGER));
    }

    private void addAutocompleteKeyword(String keyword) {
        this.trie.put(keyword, null);
    }




    }
