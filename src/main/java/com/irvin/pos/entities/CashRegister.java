package com.irvin.pos.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CashRegister {
    private long id;
    @Setter private int balance;
    @Setter private List<Transaction> transactions;
}
