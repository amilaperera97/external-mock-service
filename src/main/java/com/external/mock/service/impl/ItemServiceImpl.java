package com.external.mock.service.impl;

import com.external.mock.dto.ItemDto;
import com.external.mock.entity.Item;
import com.external.mock.entity.Shop;
import com.external.mock.repository.CategoryRepository;
import com.external.mock.repository.ItemRepository;
import com.external.mock.repository.ShopRepository;
import com.external.mock.service.ItemService;
import com.external.mock.util.converter.EntityConverter;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class ItemServiceImpl implements ItemService {
    private final EntityConverter entityConverter;
    private final ItemRepository itemRepository;
    private final CategoryRepository categoryRepository;
    private final ShopRepository shopRepository;

    @Override
    public ItemDto saveItem(ItemDto item) {
        Item itemEntity = entityConverter.convert(item, Item.class);
        itemEntity.setCategory(categoryRepository.findCategoryByName(item.getCategoryName()));
        itemEntity.setShop(shopRepository.getById(item.getShopId()));

        Item savedData = itemRepository.save(itemEntity);
        return (savedData == null) ? null : entityConverter.convert(savedData, ItemDto.class);
    }

    @Override
    public Optional<ItemDto> findItemByShop(String itemCode, Long shopId) {
        Optional<Shop> shop = shopRepository.findById(shopId);
        shop.orElseThrow(() -> new RuntimeException("Invalid Shop info"));

        Optional<Item> item = itemRepository.findItemByIdAndShop(Long.parseLong(itemCode), shop.get());
        if (item.isPresent()) {
            ItemDto itemDto = entityConverter.convert(item, ItemDto.class);
            return Optional.of(itemDto);
        }


        return Optional.empty();
    }
}
