package com.irvin.pos.entities;

import java.util.List;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Customer extends Person {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;
    @OneToMany(mappedBy = "customer")
    private List<Sale> sales;

    public Customer(String name, String identification, String address,	String phoneNumber, String email, List<Sale> sales){
        super(name, identification, address, phoneNumber, email);
        this.sales = sales;
    }
    public Customer(){
    }
    public List<Sale> getSales() {
        return sales;
    }
    public void setSales(List<Sale> sales) {
        this.sales = sales;
    }
    public long getId() {
        return id;
    }
}
