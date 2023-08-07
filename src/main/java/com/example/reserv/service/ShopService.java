package com.example.reserv.service;

import com.example.reserv.exception.CustomerEx;
import com.example.reserv.exception.ErrorCode;
import com.example.reserv.model.Shop;
import com.example.reserv.repository.ShopRepository;
import lombok.RequiredArgsConstructor;
import org.apache.commons.collections4.Trie;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ShopService {

    private final Trie trie;

    private final ShopRepository shopRepository;

//매장 검색
    public List<String> searchShop(String keyword) {
        return (List<String>) this.trie.prefixMap(keyword).keySet()
                .stream().collect(Collectors.toList());
    }

//매장 조회
    public Shop getShop(String shopName) {
        return shopRepository.findByName(shopName)
                .orElseThrow(() -> new CustomerEx(ErrorCode.NOT_FOUND_SHOP));
    }
}
