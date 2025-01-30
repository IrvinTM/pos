package com.irvin.pos.dtos;

import java.time.Instant;
import java.util.List;

import com.irvin.pos.entities.SaleItem;

public class SaleDTO {

    private long id;
    private List<SaleItem> items;
    private Instant date;
    private int discount;
    private long total;
    private long cashRegisterID;
    private Long customerID;

    public SaleDTO(){
	this.date = Instant.now();
    }

    public SaleDTO(long id, List<SaleItem> items, Instant date, int discount, long total, Long CashRegisterID, Long CostumerID){
	this.id = id;
	this.items = items;
	this.date = Instant.now();
	this.discount = discount;
	this.total = total;
	this.cashRegisterID = CashRegisterID;
	this.customerID = CostumerID;
    }
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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

	public void setDate(Instant date) {
		this.date = date;
	}

	public int getDiscount() {
		return discount;
	}

	public void setDiscount(int discount) {
		this.discount = discount;
	}

	public long getTotal() {
		return total;
	}

	public void setTotal(long total) {
		this.total = total;
	}

	public Long getCashRegisterID() {
		return cashRegisterID;
	}

	public void setCashRegisterID(Long cashRegisterID) {
		this.cashRegisterID = cashRegisterID;
	}

	public Long getCustomerID() {
		return customerID;
	}

	public void setCustomer(Long customerID) {
		this.customerID = customerID;
	}
}

