package com.irvin.pos.entities;

import java.time.Instant;
import java.util.List;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Sale {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;
    @OneToMany(mappedBy = "sale")
    private List<Product> products;
    private Instant date;
    private int discount;
    private long total;
    @ManyToOne
    @JoinColumn(name = "cash_register_id")
    private CashRegister cashRegister;
    @ManyToOne
    @JoinColumn(name = "customer")
    private Customer customer;

    public Sale(){
        this.date = Instant.now();
    }

    public Sale(List<Product> products, Instant date, int discount, long total ){
        this.products = products;
        this.date = Instant.now();
        this.discount = discount;
	this.total = total;
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

	public void setDate(Instant date) {
		this.date = date;
	}

	public long getTotal() {
		return total;
	}

	public void setTotal(long total) {
		this.total = total;
	}
}
