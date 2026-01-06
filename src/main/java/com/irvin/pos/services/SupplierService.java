package com.irvin.pos.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.irvin.pos.dtos.CustomPageDTO;
import com.irvin.pos.dtos.SupplierDTO;
import com.irvin.pos.entities.Stock;
import com.irvin.pos.entities.Supplier;
import com.irvin.pos.exceptions.PropertyAlreadyExistException;
import com.irvin.pos.repositories.StockRepository;
import com.irvin.pos.repositories.SupplierRepository;
import com.irvin.pos.utils.CustomPage;
import com.irvin.pos.utils.ObjectMapper;

@Service
public class SupplierService {

    @Autowired
    private SupplierRepository supplierRepository;
    
    @Autowired
    private StockRepository stockRepository;

    public SupplierDTO createSupplier(SupplierDTO supplierDTO) throws PropertyAlreadyExistException {
        if (supplierRepository.getByIdentification(supplierDTO.getIdentification()) != null) {
            throw new PropertyAlreadyExistException("identification", String.valueOf(supplierDTO.getIdentification()));
        } else if (supplierRepository.getByPhoneNumber(supplierDTO.getPhoneNumber()) != null) {
            throw new PropertyAlreadyExistException("phone_number", supplierDTO.getPhoneNumber());
        } else if (supplierRepository.getByEmail(supplierDTO.getEmail()) != null) {
            throw new PropertyAlreadyExistException("email", supplierDTO.getEmail());
        }
        
        List<Stock> stocks = new ArrayList<>();
        if (supplierDTO.getStocks() != null) {
            supplierDTO.getStocks().forEach(id -> {
                Optional<Stock> stock = stockRepository.findById(id);
                stock.ifPresent(stocks::add);
            });
        }
        
        Supplier supplier = ObjectMapper.dtoToSupplier(supplierDTO, stocks);
        return ObjectMapper.supplierToDTO(supplierRepository.save(supplier));
    }

    public SupplierDTO updateSupplier(SupplierDTO supplierDTO) {
        Optional<Supplier> existingSupplierOpt = supplierRepository.findById(supplierDTO.getId());
        if (existingSupplierOpt.isPresent()) {
            Supplier existingSupplier = existingSupplierOpt.get();
            
            // Fetch stocks if needed, though usually we don't update stocks this way for OneToMany mappedBy
            List<Stock> stocks = new ArrayList<>();
            if (supplierDTO.getStocks() != null) {
                supplierDTO.getStocks().forEach(id -> {
                    Optional<Stock> stock = stockRepository.findById(id);
                    stock.ifPresent(stocks::add);
                });
            }
            
            existingSupplier.setName(supplierDTO.getName());
            existingSupplier.setIdentification(supplierDTO.getIdentification());
            existingSupplier.setAddress(supplierDTO.getAddress());
            existingSupplier.setPhoneNumber(supplierDTO.getPhoneNumber());
            existingSupplier.setEmail(supplierDTO.getEmail());
            // existingSupplier.setStocks(stocks); // Typically managed by Stock side, but setting for consistency
            
            return ObjectMapper.supplierToDTO(supplierRepository.save(existingSupplier));
        } else {
            throw new IllegalArgumentException("Supplier not found");
        }
    }

    public void deleteSupplier(long id) {
        supplierRepository.deleteById(id);
    }

    public CustomPageDTO<SupplierDTO> getAllSuppliers() {
        CustomPageDTO<SupplierDTO> page = new CustomPageDTO<>();
        Page<Supplier> supplierPage = supplierRepository.findAll(PageRequest.of(0, 10));
        supplierPage.getContent().forEach(supplier -> {
            page.addContent(ObjectMapper.supplierToDTO(supplier));
        });
        CustomPage customPage = new CustomPage(
            supplierPage.getTotalElements(),
            supplierPage.getTotalPages(),
            supplierPage.getNumber(),
            supplierPage.getSize()
        );
        page.setCustomPage(customPage);
        return page;
    }
    
    public SupplierDTO getSupplierById(long id) {
        return ObjectMapper.supplierToDTO(supplierRepository.getReferenceById(id));
    }
}