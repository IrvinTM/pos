package com.irvin.pos.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.irvin.pos.entities.Sale;
import com.irvin.pos.services.SaleService;

@RestController
@RequestMapping("/api/sales")
public class SaleController {

    @Autowired
    private SaleService saleService;
    
    @PostMapping("/add")
    public ResponseEntity<Sale> addSale(@RequestBody Sale sale){
        Sale s = saleService.addSale(sale);
        return ResponseEntity.ok(s);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Sale> deleteSale(@RequestParam long id){
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @GetMapping
    public Page<Sale> getAllSales(){
        return saleService.getAllSales();
    }

}
