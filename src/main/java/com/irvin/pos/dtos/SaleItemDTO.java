package com.irvin.pos.dtos;

public class SaleItemDTO{

    private Long id, productId, priceAtSale, saleId;
    private int quantity;

    public SaleItemDTO(){}

    public SaleItemDTO(Long id, Long productId, int quantity, Long priceAtSale ) {
        this.id = id;
        this.productId = productId;
        this.quantity = quantity;
        this.priceAtSale = priceAtSale;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Long getProductId() {
        return productId;
    }
    public void setProductId(Long productId) {
        this.productId = productId;
    }
    public Long getPriceAtSale() {
        return priceAtSale;
    }
    public void setPriceAtSale(Long priceAtSale) {
        this.priceAtSale = priceAtSale;
    }
    public Long getSaleId() {
        return saleId;
    }
    public void setSaleId(Long saleId) {
        this.saleId = saleId;
    }
    public int getQuantity() {
        return quantity;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
