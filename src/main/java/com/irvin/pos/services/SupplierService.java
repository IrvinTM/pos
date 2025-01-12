package com.irvin.pos.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import com.irvin.pos.entities.Supplier;
import com.irvin.pos.exceptions.PropertyAlreadyExistException;
import com.irvin.pos.repositories.SupplierRepository;

@Service
public class SupplierService {

    @Autowired
    SupplierRepository supplierRepository;
    
    public Supplier createSupplier(Supplier supplier) throws PropertyAlreadyExistException {
        if (supplierRepository.getByIdentification(supplier.getIdentification()) != null

        ) {
            throw new PropertyAlreadyExistException("identification", String.valueOf(supplier.getIdentification()));
        } else if (supplierRepository.getByPhoneNumber(supplier.getPhoneNumber()) != null) {
            throw new PropertyAlreadyExistException("phone_number", supplier.getPhoneNumber());
        } else if (supplierRepository.getByEmail(supplier.getEmail()) != null) {
            throw new PropertyAlreadyExistException("email", supplier.getEmail());
        }
        return supplierRepository.save(supplier);
    }
    
    public Supplier updateSupplier(Supplier supplier){
        return supplierRepository.save(supplier);
    }

    public void deleteSupplier(long id){
        supplierRepository.deleteById(id);
    }

    public Page<Supplier> getAllSuppliers(){
        Page<Supplier> peoplePage = supplierRepository.findAll(PageRequest.of(0, 10));
        return peoplePage;
    }
}
