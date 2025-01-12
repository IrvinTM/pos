package com.irvin.pos.entities;


import java.util.List;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

public class Supplier extends Person {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;
    @OneToMany(mappedBy = "supplier")
    private List<Stock> stocks;

    public Supplier(String name, String identification, String address,	String phoneNumber, String email, List<Stock> stocks){
        super(name, identification, address, phoneNumber, email);
        this.stocks = stocks;
    }
    public Supplier(){
    }
    public List<Stock> getStocks() {
        return stocks;
    }
    public void setSales(List<Stock> stocks) {
        this.stocks = stocks;
    }
    public long getId() {
        return id;
    }
}
