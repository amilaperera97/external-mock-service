package com.external.mock.service;

import com.external.mock.entity.Shop;

public interface ShopService {
    Shop findByName(String name);
}
