package com.irvin.pos.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import com.irvin.pos.entities.CashRegister;
import com.irvin.pos.repositories.CashRegisterRepository;

/**
 * CashRegisterService
 */
public class CashRegisterService {

    private CashRegisterRepository cashRegisterRepository;

    public CashRegister createCashRegister(CashRegister cashRegister){
        return cashRegisterRepository.save(cashRegister);
    }

    public CashRegister getCashRegisterById(long id){
        return cashRegisterRepository.getReferenceById(id);
    }

    public Page<CashRegister> getAllCashRegister(){
        return cashRegisterRepository.findAll(PageRequest.of(0, 10));
    }
}
