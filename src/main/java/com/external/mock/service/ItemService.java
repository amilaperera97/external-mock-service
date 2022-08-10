package com.external.mock.service;

import com.external.mock.dto.ItemDto;
import com.external.mock.dto.ShopNames;
import com.external.mock.dto.aldi.ProductInfoDto;
import com.external.mock.dto.aldi.ProductInfoPriceDto;

import java.util.Optional;

public interface ItemService {
    ItemDto saveItem(ItemDto item);

    Optional<ItemDto> findItemByShop(String itemCode, Long shopId);

    ProductInfoDto productInfo(String itemCode, ShopNames shopName) throws Exception;

    ProductInfoPriceDto productPriceInfo(String itemCode, ShopNames shopName) throws Exception;
}
