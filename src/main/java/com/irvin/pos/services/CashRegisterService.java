package com.irvin.pos.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.irvin.pos.dtos.CustomPageDTO;
import com.irvin.pos.entities.CashRegister;
import com.irvin.pos.repositories.CashRegisterRepository;
import com.irvin.pos.utils.CustomPage;

/**
 * CashRegisterService
 */
@Service
public class CashRegisterService {

    @Autowired
    private CashRegisterRepository cashRegisterRepository;

    public CashRegister createCashRegister(CashRegister cashRegister) {
        return cashRegisterRepository.save(cashRegister);
    }

    public CashRegister getCashRegisterById(Long id) {
        return cashRegisterRepository.getReferenceById(id);
    }

    public CustomPageDTO<CashRegister> getAllCashRegister() {
        CustomPageDTO<CashRegister> page = new CustomPageDTO<>();
        Page<CashRegister> p = cashRegisterRepository.findAll(PageRequest.of(0, 10));
        CustomPage customPage = new CustomPage(p.getTotalElements(), p.getTotalPages(), p.getNumber(), p.getSize());
        page.setContent(p.getContent());
        page.setCustomPage(customPage);
        return page;
    }
}
