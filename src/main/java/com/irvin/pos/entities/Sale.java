package com.irvin.pos.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class Sale {
    private long id;
    @Setter private List<Product> products;
    @Setter private LocalDateTime date;
    @Setter private int discount;
}
