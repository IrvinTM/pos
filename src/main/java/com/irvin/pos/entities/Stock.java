package com.irvin.pos.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Stock {

    private long id;
    @Setter private List<Product> products;
    @Setter private long total;
    //get the created and modified from the db maybe ?
}
