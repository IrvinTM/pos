package com.irvin.pos.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import com.irvin.pos.dtos.CustomPageDTO;
import com.irvin.pos.entities.Tax;
import com.irvin.pos.exceptions.PropertyAlreadyExistException;
import com.irvin.pos.repositories.TaxRepository;

//TODO change to the dto for Tax
@Service
public class TaxService {

    @Autowired
    private TaxRepository taxRepository;

    public Tax createTax(Tax tax) throws PropertyAlreadyExistException{
        if (taxRepository.getByName(tax.getName()) != null) {
            throw new PropertyAlreadyExistException("name", tax.getName());
        }else if(taxRepository.getByCode(tax.getCode()) != null){
            throw new PropertyAlreadyExistException("code", tax.getCode());
        }
        return taxRepository.save(tax);
    }

    public CustomPageDTO<Tax> getAllTaxes(){
        CustomPageDTO<Tax> page =
            new CustomPageDTO<>(
                    taxRepository.findAll(PageRequest.of(0, 10))
                    );
        return page;
    }

    public Tax getTaxByID(long id){
        return taxRepository.getReferenceById(id);
    }

    public Tax updateTax(Tax tax)throws Exception{
        Optional<Tax> t = taxRepository.findById(tax.getId());
        if (t.isPresent()) {
            return t.get();
        }else{
            throw new Exception("tax not found");
        }
    }
    public void deleteTax(long id){
        taxRepository.deleteById(id);
    }
}
