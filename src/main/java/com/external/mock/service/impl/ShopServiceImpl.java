package com.external.mock.service.impl;

import com.external.mock.entity.Shop;
import com.external.mock.repository.ShopRepository;
import com.external.mock.service.ShopService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ShopServiceImpl implements ShopService {
    private final ShopRepository shopRepository;
    @Override
    public Shop findByName(String name) {
        return shopRepository.findShopByName(name);
    }
}
