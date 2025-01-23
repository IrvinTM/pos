package com.irvin.pos.entities;

import java.time.Instant;
import java.util.List;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Sale {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;
    @ElementCollection
    @CollectionTable(name = "sale_items")
    private List<SaleItem> items;
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
    }

    public Sale(List<SaleItem> items, Instant date, int discount, long total ){
        this.items = items;
        this.date = date;
        this.discount = discount;
	this.total = total;
    }

    public Sale(Sale sale){
        this.items = sale.getItems();
        this.date = sale.getDate();
        this.discount = sale.getDiscount();
    }

	public long getId() {
		return id;
	}
	public List<SaleItem> getItems() {
		return items;
	}
	public void setItems(List<SaleItem> items) {
		this.items = items;
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
