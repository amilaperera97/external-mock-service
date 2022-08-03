package com.external.mock.rest;

import com.external.mock.dto.aldi.PaymentDto;
import com.external.mock.dto.aldi.ProductInfoDto;
import com.external.mock.dto.aldi.ProductInfoPriceDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import static com.external.mock.util.Constant.Aldi.*;

@RequestMapping(value = HOST)
public class AldiController {

    @GetMapping(value = PRODUCT_INFO)
    public ProductInfoDto productInfo(@PathVariable("product-id") String productId) {
        return null;
    }

    @GetMapping(value = PRODUCT_PRICE_INFO)
    public ProductInfoPriceDto productPriceInfo(@PathVariable("product-id") String productId) {
        return null;
    }

    @PostMapping(value = PAYMENT)
    public ResponseEntity payment(@Valid @RequestBody PaymentDto payment) {
        return new ResponseEntity(HttpStatus.ACCEPTED);
    }
}
