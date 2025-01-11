package com.irvin.pos.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import com.irvin.pos.entities.Sale;
import com.irvin.pos.repositories.SaleRepository;


@Service
public class SaleService {

    @Autowired
    private SaleRepository saleRepository;
    
    public Sale addSale(Sale sale){
        return saleRepository.save(sale);
    }
    public void removeSale(long id){
        saleRepository.deleteById(id);
    }
    //TODO implemet proper pagination
    public Page<Sale> getAllSales(){
        return saleRepository.findAll(PageRequest.of(0, 10));
    }

}
