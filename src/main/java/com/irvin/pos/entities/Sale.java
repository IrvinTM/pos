package com.irvin.pos.entities;

import java.time.Instant;
import java.util.List;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Sale {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;
    private List<Product> products;
    private Instant date;
    private int discount;

    public Sale(){
        this.date = Instant.now();
    }

    public Sale(List<Product> products, Instant date, int discount ){
        this.products = products;
        this.date = Instant.now();
        this.discount = discount;
    }

    public Sale(Sale sale){
        this.products = sale.getProducts();
        this.date = Instant.now();
        this.discount = sale.getDiscount();
    }

	public long getId() {
		return id;
	}
	public List<Product> getProducts() {
		return products;
	}
	public void setProducts(List<Product> products) {
		this.products = products;
	}
	public Instant getDate() {
		return date;
	}
	public int getDiscount() {
		return discount;
	}
	public void setDiscount(int discount) {
		this.discount = discount;
	}
}
