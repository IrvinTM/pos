package com.irvin.pos.dtos;

import com.irvin.pos.entities.Customer;

public class CustomerDTO {
    private long id;
    private String name;
    private String identification;
    private String address;
    private String phoneNumber;
    private String email;

    public CustomerDTO() {
    }

    public CustomerDTO(long id, String name, String identification, String address, String phoneNumber, String email) {
        this.id = id;
        this.name = name;
        this.identification = identification;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public static CustomerDTO fromEntity(Customer customer) {
        return new CustomerDTO(
            customer.getId(),
            customer.getName(),
            customer.getIdentification(),
            customer.getAddress(),
            customer.getPhoneNumber(),
            customer.getEmail()
        );
    }

    public Customer toEntity() {
        Customer customer = new Customer();
        customer.setName(this.name);
        customer.setIdentification(this.identification);
        customer.setAddress(this.address);
        customer.setPhoneNumber(this.phoneNumber);
        customer.setEmail(this.email);
        return customer;
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
}
