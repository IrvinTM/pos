package com.irvin.pos.dtos;

import java.util.ArrayList;

import com.irvin.pos.entities.CashRegister;

public class CashRegisterDTO {
    private Long balance;
    private Long[] transactions;
    private Long[] sales;

    public CashRegisterDTO(Long balance, Long[] transactions, Long[] sales) {
        this.balance = balance;
        this.transactions = transactions;
        this.sales = sales;
    }

    public static CashRegisterDTO fromEntity(CashRegister cashRegister) {
        ArrayList<Long> sales = new ArrayList<Long>();
        ArrayList<Long> transactions = new ArrayList<Long>();
        CashRegisterDTO cr = new CashRegisterDTO();
        cr.setBalance(cashRegister.getBalance());
        cashRegister.getSales().forEach(sale -> sales.add(sale.getId()));
        cashRegister.getTransactions().forEach(t -> transactions.add(t.getId()));
        return cr;
    }

    public CashRegisterDTO() {
    }

    public Long getBalance() {
        return balance;
    }

    public void setBalance(Long balance) {
        this.balance = balance;
    }

    public Long[] getTransactions() {
        return transactions;
    }

    public void setTransactions(Long[] transactions) {
        this.transactions = transactions;
    }

    public Long[] getSales() {
        return sales;
    }

    public void setSales(Long[] sales) {
        this.sales = sales;
    }

}
