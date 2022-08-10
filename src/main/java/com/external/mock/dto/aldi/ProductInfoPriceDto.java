package com.external.mock.dto.aldi;

import lombok.Data;

@Data
public class ProductInfoPriceDto {
    private String price;
    private Boolean isDiscounted;
    private String unitPrice;
    private String currencyType;
    private Boolean isOnSale;
    private Boolean isMultiBuyOffer;
}
