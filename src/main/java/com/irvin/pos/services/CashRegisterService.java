package com.irvin.pos.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.irvin.pos.dtos.CashRegisterDTO;
import com.irvin.pos.dtos.CustomPageDTO;
import com.irvin.pos.entities.CashRegister;
import com.irvin.pos.entities.Sale;
import com.irvin.pos.repositories.CashRegisterRepository;
import com.irvin.pos.repositories.SaleRepository;
import com.irvin.pos.utils.CustomPage;

/**
 * CashRegisterService
 */
@Service
public class CashRegisterService {

    @Autowired
    private CashRegisterRepository cashRegisterRepository;

    @Autowired
    private SaleRepository saleRepository;


    // TODO change all the methods to return the dto instead
    public CashRegisterDTO createCashRegister(CashRegisterDTO cashRegisterdDto) {
        CashRegister cr = new CashRegister();
        ArrayList<Sale> sales = new ArrayList<>();
        ArrayList<> sales = new ArrayList<>();
        cr.setBalance(cashRegisterdDto.getBalance());
        for (int s = 0; s < cashRegisterdDto.getSales().length; s++) {
            sales.add(saleRepository.getReferenceById(cashRegisterdDto.getSales()[s]));
        }

        return CashRegisterDTO.fromEntity(cashRegisterRepository.save(cashRegisterdDto));
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
