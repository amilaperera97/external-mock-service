package com.external.mock.dto;
import lombok.Data;
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
    private WeightDto weight;
    private String categoryName;
    private Long shopId;
}
