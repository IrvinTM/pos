package com.irvin.pos.dtos;

import java.util.List;

public class SupplierDTO {

    private long id;
    private String name;
    private String identification;
    private String address;
    private String phoneNumber;
    private String email;
    private List<Long> stocks;

    public SupplierDTO() {
    }

    public SupplierDTO(long id, String name, String identification, String address, String phoneNumber, String email, List<Long> stocks) {
        this.id = id;
        this.name = name;
        this.identification = identification;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.stocks = stocks;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIdentification() {
        return identification;
    }

    public void setIdentification(String identification) {
        this.identification = identification;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Long> getStocks() {
        return stocks;
    }

    public void setStocks(List<Long> stocks) {
        this.stocks = stocks;
    }
}
