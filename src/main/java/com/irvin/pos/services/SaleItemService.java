package com.irvin.pos.services;

import org.springframework.stereotype.Service;

import com.irvin.pos.dtos.SaleItemDTO;
import com.irvin.pos.repositories.SaleItemRepository;
import com.irvin.pos.utils.ObjectMapper;

@Service
public class SaleItemService {
    
    private SaleItemRepository saleItemRepository;


    public SaleItemDTO createSaleItem(SaleItemDTO saleItemDTO){
        return saleItemRepository.save(ObjectMapper.)

    }

    public SaleItemDTO findById(long id){
        return ObjectMapper.saleItemToDTO(saleItemRepository.findById(id).get());
    }
}
