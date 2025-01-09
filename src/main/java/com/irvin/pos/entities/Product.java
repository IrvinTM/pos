package com.irvin.pos.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Product {
    private long id;
    private String name;
    private long code;
    private String barCode;
    private String measurementUnit;
    private Category category;
    private boolean isActive;
    private boolean isAgeRestricted;
    private String description;
    private String image;
    private int cost;
    private List<Tax> taxes;
    private boolean priceIncludesTaxes;
    private boolean allowPriceChange;
    private int noTaxIncludedPrice;
    private int TaxIncludedPrice;
    private int profitMargin;
    private int salesPrice;
}