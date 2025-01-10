package com.irvin.pos.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class Transaction {
    private long id;
    @Setter private int amount;
    @Setter private LocalDateTime date;
    @Setter private TransactionType transactionType;
}