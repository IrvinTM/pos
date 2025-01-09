package com.irvin.pos.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    private long id;
    @Setter private String name;
    @Setter private long code;
    @Setter private String barCode;
    @Setter private String measurementUnit;
    @Setter private Category category;
    @Setter private boolean isActive;
    @Setter private boolean isAgeRestricted;
    @Setter private String description;
    @Setter private String image;
    @Setter private int cost;
    @Setter private List<Tax> taxes;
    @Setter private boolean priceIncludesTaxes;
    @Setter private boolean allowPriceChange;
    @Setter private int noTaxIncludedPrice;
    @Setter private int taxIncludedPrice;
    @Setter private int profitMargin;
    @Setter private int salesPrice;
    @Setter private int stock;
}