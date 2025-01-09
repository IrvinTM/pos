package com.irvin.pos.entities;

import java.time.LocalDateTime;
import java.util.List;

public class StockDocument {
    private List<Stock> stocks;
    private LocalDateTime lastUpdateDate;
    private LocalDateTime createdDate;
}
