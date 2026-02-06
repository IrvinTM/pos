package com.irvin.pos.dtos;

public class CashRegisterDTO {
    private Long balance;
    private int[] transactions;
    private int[] sales;

    public CashRegisterDTO(Long balance, int[] transactions, int[] sales) {
        this.balance = balance;
        this.transactions = transactions;
        this.sales = sales;
    }

    public CashRegisterDTO() {
    }

    public Long getBalance() {
        return balance;
    }

    public void setBalance(Long balance) {
        this.balance = balance;
    }

    public int[] getTransactions() {
        return transactions;
    }

    public void setTransactions(int[] transactions) {
        this.transactions = transactions;
    }

    public int[] getSales() {
        return sales;
    }

    public void setSales(int[] sales) {
        this.sales = sales;
    }

}
