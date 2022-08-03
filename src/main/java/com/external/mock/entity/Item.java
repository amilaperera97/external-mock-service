package com.external.mock.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
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

    @OneToOne
    private Weight weight;
    @OneToMany(mappedBy = "item")
    private List<Image> images;
    @OneToOne
    private Category category;
    @OneToOne
    private Shop shop;
}
