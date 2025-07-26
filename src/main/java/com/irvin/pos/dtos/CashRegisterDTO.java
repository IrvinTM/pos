package com.irvin.pos.dtos;

public class CashRegisterDTO {
    private long balance;
    private int[] transactions;
    private int[] sales;

    public CashRegisterDTO(long balance, int[] transactions, int[] sales) {
        this.balance = balance;
        this.transactions = transactions;
        this.sales = sales;
    }

    public CashRegisterDTO() {
    }

    public long getBalance() {
        return balance;
    }

    public void setBalance(long balance) {
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
