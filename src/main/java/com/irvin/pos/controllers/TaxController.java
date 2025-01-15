package com.irvin.pos.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.irvin.pos.dtos.CustomPageDTO;
import com.irvin.pos.entities.Tax;
import com.irvin.pos.services.TaxService;

@RestController
@RequestMapping("/api/taxes")
public class TaxController {

    @Autowired
    private TaxService taxService;

    @GetMapping
    public CustomPageDTO<Tax> getAll(){
        return taxService.getAllTaxes();
    }

    @PostMapping("/create")
    public ResponseEntity<Tax> CreateTax(@RequestBody Tax tax)throws Exception{
        return ResponseEntity.ok(
                taxService.createTax(tax));
    }

    @PutMapping("/update")
    public ResponseEntity<Tax> updateTax(@RequestBody Tax tax) throws Exception{
        return ResponseEntity.ok(
                taxService.updateTax(tax)
                );
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteTax(@PathVariable long id){
        taxService.deleteTax(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
