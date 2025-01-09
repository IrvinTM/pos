package com.irvin.pos.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor


public class Stock {
    @Getter private long id;
    @Getter @Setter private List<Product> products;
    @Getter @Setter private int Quantity;
    //get the created and modified from the db maybe ?
}
