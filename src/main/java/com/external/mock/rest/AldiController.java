package com.external.mock.rest;

import com.external.mock.dto.ShopNames;
import com.external.mock.dto.aldi.PaymentDto;
import com.external.mock.dto.aldi.ProductInfoDto;
import com.external.mock.dto.aldi.ProductInfoPriceDto;
import com.external.mock.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import static com.external.mock.util.Constant.Aldi.*;

@RestController
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
    public ResponseEntity<HttpStatus> payment(@Valid @RequestBody PaymentDto payment) {
        if ((payment.getCardNumber().length() != 16 || payment.getCardNumber().length() != 19)
                && (payment.getCvc().length() != 3) && payment.getExpiryDate().length() != 4)
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }
}
