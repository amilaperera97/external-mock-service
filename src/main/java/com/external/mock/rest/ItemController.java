package com.external.mock.rest;

import com.external.mock.dto.ItemDto;
import com.external.mock.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.external.mock.util.Constant.EndpointInfo.API_V1;
import static com.external.mock.util.Constant.EndpointInfo.ITEM;

@RestController
@RequestMapping(value = API_V1)
@RequiredArgsConstructor
public class ItemController {
    private final ItemService itemService;

    @PostMapping(ITEM)
    public ItemDto save(@RequestBody ItemDto item) {
        return itemService.saveItem(item);
    }
}
