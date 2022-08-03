package com.external.mock.dto;

import com.external.mock.entity.Category;
import com.external.mock.entity.Image;
import com.external.mock.entity.Shop;
import com.external.mock.entity.Weight;
import lombok.Data;

import java.util.List;

@Data
public class ItemDto {
    private String name;
    private String price;
    private Boolean isDiscounted;
    private String unitPrice;
    private String currencyType;
    private Boolean isOnSale;
    private String nutritionInformation;
    private String lifestyle;
    private String ingredients;
    private String allergyAdvice;
    private String brand;
    private String manufacturer;
    private String countryOfOrigin;
    private String storageInstructions;
    private Boolean isMultiBuyOffer;
    private Weight weight;
    private List<Image> images;
    private String categoryName;
    private Long shopId;
}
