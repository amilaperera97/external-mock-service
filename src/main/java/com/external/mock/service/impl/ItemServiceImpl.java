package com.external.mock.service.impl;

import com.external.mock.dto.ItemDto;
import com.external.mock.dto.ShopNames;
import com.external.mock.dto.aldi.ProductInfoDto;
import com.external.mock.dto.aldi.ProductInfoPriceDto;
import com.external.mock.entity.Item;
import com.external.mock.entity.Shop;
import com.external.mock.entity.Weight;
import com.external.mock.repository.CategoryRepository;
import com.external.mock.repository.ItemRepository;
import com.external.mock.repository.ShopRepository;
import com.external.mock.repository.WeightRepository;
import com.external.mock.service.ItemService;
import com.external.mock.util.converter.EntityConverter;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static com.external.mock.util.CommonUtil.barcodeGenerator;

@Service
@AllArgsConstructor
public class ItemServiceImpl implements ItemService {
    private final EntityConverter entityConverter;
    private final ItemRepository itemRepository;
    private final CategoryRepository categoryRepository;
    private final ShopRepository shopRepository;
    private final WeightRepository weightRepository;

    @Override
    public ItemDto saveItem(ItemDto item) {
        Item itemEntity = entityConverter.convert(item, Item.class);
        assignItemData(item, itemEntity);

        Item savedData = itemRepository.save(itemEntity);
        return (savedData == null) ? null : entityConverter.convert(savedData, ItemDto.class);
    }

    private void assignItemData(ItemDto item, Item itemEntity) {
        itemEntity.setCategory(categoryRepository.findCategoryByName(item.getCategoryName()));
        itemEntity.setShop(shopRepository.getById(item.getShopId()));
        itemEntity.setId(barcodeGenerator(15));

        Weight weightEntity = entityConverter.convert(item.getWeight(), Weight.class);
        weightEntity = weightRepository.save(weightEntity);

        itemEntity.setWeight(weightEntity);
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

    @Override
    public ProductInfoDto productInfo(String itemCode, ShopNames shopName) throws Exception {
        Shop shop = shopRepository.findShopByName(shopName.name());
        Optional<ItemDto> itemDto = findItemByShop(itemCode, shop.getId());
        itemDto.orElseThrow(() -> new Exception("Invalid Id"));
        ProductInfoDto productInfo = entityConverter.convert(itemDto.get(), ProductInfoDto.class);
        return productInfo;
    }

    @Override
    public ProductInfoPriceDto productPriceInfo(String itemCode, ShopNames shopName) throws Exception {
        return null;
    }
}
