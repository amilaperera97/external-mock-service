package com.external.mock.rest;

import com.external.mock.dto.ItemDto;
import com.external.mock.dto.ShopNames;
import com.external.mock.dto.aldi.PaymentDto;
import com.external.mock.dto.aldi.ProductInfoDto;
import com.external.mock.dto.aldi.ProductInfoPriceDto;
import com.external.mock.entity.Shop;
import com.external.mock.service.ItemService;
import com.external.mock.service.ShopService;
import com.external.mock.util.converter.EntityConverter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.swing.tree.TreeNode;
import javax.validation.Valid;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import static com.external.mock.util.Constant.Aldi.*;

@RequestMapping(value = HOST)
@RequiredArgsConstructor
public class AldiController {
    private final ItemService itemService;

    @GetMapping(value = PRODUCT_INFO)
    public ProductInfoDto productInfo(@PathVariable("product-id") String productId) throws Exception {
        return itemService.productInfo(productId, ShopNames.ALDI);
    }

    @GetMapping(value = PRODUCT_PRICE_INFO)
    public ProductInfoPriceDto productPriceInfo(@PathVariable("product-id") String productId) throws Exception {
        return itemService.productPriceInfo(productId, ShopNames.ALDI);
    }

    @PostMapping(value = PAYMENT)
    public ResponseEntity payment(@Valid @RequestBody PaymentDto payment) {
        List<String> samples= new LinkedList<>();
        return new ResponseEntity(HttpStatus.ACCEPTED);
    }
}
