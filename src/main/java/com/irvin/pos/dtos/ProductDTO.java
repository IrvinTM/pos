package com.irvin.pos.dtos;

import java.util.List;

public class ProductDTO {

	private Long id;
    private String name;
    private String code;
    private String barCode;
    private String measurementUnit;
    private List<Long> categories;
    private boolean isActive;
    private boolean isAgeRestricted;
    private String description;
    private String image;
    private Long cost;
    private List<Long> taxes;
    private boolean priceIncludesTaxes;
    private boolean allowPriceChange;
    private Long noTaxIncludedPrice;
    private Long taxIncludedPrice;
    private Long profitMargin;
    private Long salesPrice;
    private Long available;

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getBarCode() {
		return barCode;
	}
	public void setBarCode(String barCode) {
		this.barCode = barCode;
	}
	public String getMeasurementUnit() {
		return measurementUnit;
	}
	public void setMeasurementUnit(String measurementUnit) {
		this.measurementUnit = measurementUnit;
	}
	public List<Long> getCategories() {
		return categories;
	}
	public void setCategories(List<Long> categories) {
		this.categories = categories;
	}
	public boolean isActive() {
		return isActive;
	}
	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
	public boolean isAgeRestricted() {
		return isAgeRestricted;
	}
	public void setAgeRestricted(boolean isAgeRestricted) {
		this.isAgeRestricted = isAgeRestricted;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public Long getCost() {
		return cost;
	}
	public void setCost(Long cost) {
		this.cost = cost;
	}
	public List<Long> getTaxes() {
		return taxes;
	}
	public void setTaxes(List<Long> taxes) {
		this.taxes = taxes;
	}
	public boolean isPriceIncludesTaxes() {
		return priceIncludesTaxes;
	}
	public void setPriceIncludesTaxes(boolean priceIncludesTaxes) {
		this.priceIncludesTaxes = priceIncludesTaxes;
	}
	public boolean isAllowPriceChange() {
		return allowPriceChange;
	}
	public void setAllowPriceChange(boolean allowPriceChange) {
		this.allowPriceChange = allowPriceChange;
	}
	public Long getNoTaxIncludedPrice() {
		return noTaxIncludedPrice;
	}
	public void setNoTaxIncludedPrice(Long noTaxIncludedPrice) {
		this.noTaxIncludedPrice = noTaxIncludedPrice;
	}
	public Long getTaxIncludedPrice() {
		return taxIncludedPrice;
	}
	public void setTaxIncludedPrice(Long taxIncludedPrice) {
		this.taxIncludedPrice = taxIncludedPrice;
	}
	public Long getProfitMargin() {
		return profitMargin;
	}
	public void setProfitMargin(Long profitMargin) {
		this.profitMargin = profitMargin;
	}
	public Long getSalesPrice() {
		return salesPrice;
	}
	public void setSalesPrice(Long salesPrice) {
		this.salesPrice = salesPrice;
	}
	public Long getAvailable() {
		return available;
	}
	public void setAvailable(Long available) {
		this.available = available;
	}
}
