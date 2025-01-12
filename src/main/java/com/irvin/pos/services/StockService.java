package com.irvin.pos.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.irvin.pos.entities.Stock;
import com.irvin.pos.repositories.StockRepository;

@Service
public class StockService {

    @Autowired
    private StockRepository stockRepository;

    public Stock createNewStok(Stock stock){
        return stockRepository.save(stock);
    }

    public Page<Stock> getAllStocks(){
        return stockRepository.findAll(PageRequest.of(0, 10));
    }

}
