package com.irvin.pos.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import com.irvin.pos.entities.Tax;
import com.irvin.pos.exceptions.PropertyAlreadyExistException;
import com.irvin.pos.repositories.TaxRepository;

public class TaxService {

    private TaxRepository taxRepository;

    public Tax createTax(Tax tax) throws PropertyAlreadyExistException{
        if (taxRepository.getByName(tax.getName()) != null) {
            throw new PropertyAlreadyExistException("name", tax.getName());
        }else if(taxRepository.getByCode(tax.getCode()) != null){
            throw new PropertyAlreadyExistException("code", tax.getCode());
        }
        return taxRepository.save(tax);
    }

    public Page<Tax> getAllTaxes(){
        return taxRepository.findAll(PageRequest.of(0, 10));
    }
}
