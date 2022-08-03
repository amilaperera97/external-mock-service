package com.external.mock.service;

import com.external.mock.dto.ItemDto;

import java.util.Optional;

public interface ItemService {
    ItemDto saveItem(ItemDto item);

    Optional<ItemDto> findItemByShop(String itemCode, Long shopId);
}
