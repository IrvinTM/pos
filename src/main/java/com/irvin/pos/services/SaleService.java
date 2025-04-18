package com.irvin.pos.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import com.irvin.pos.dtos.CustomPageDTO;
import com.irvin.pos.dtos.SaleDTO;
import com.irvin.pos.entities.CashRegister;
import com.irvin.pos.entities.Customer;
import com.irvin.pos.entities.Sale;
import com.irvin.pos.repositories.CashRegisterRepository;
import com.irvin.pos.repositories.CustomerRepository;
import com.irvin.pos.repositories.SaleRepository;
import com.irvin.pos.utils.CustomPage;
import com.irvin.pos.utils.ObjectMapper;


@Service
public class SaleService {

    @Autowired
    private SaleRepository saleRepository;

    @Autowired
    private CustomerRepository customerRepository;
    
    @Autowired
    private CashRegisterRepository cashRegisterRepository;
    
    public Sale addSale(SaleDTO saleDTO){
        Optional<Customer> customer = customerRepository.findById(saleDTO.getCustomerID());
        if(customer.isEmpty()){
            throw new IllegalArgumentException("Customer not found");
        }
        Optional<CashRegister> cashRegister = cashRegisterRepository.findById(saleDTO.getCashRegisterID());
        if(cashRegister.isEmpty()){
            throw new IllegalArgumentException("Cash Register not found");
        }
        return saleRepository.save(ObjectMapper.dtoToSale(saleDTO, cashRegister.get(), customer.get()));
    }

    public void deleteSale(long id){
        saleRepository.deleteById(id);
    }

    public CustomPageDTO<SaleDTO> getAllSales(){
        Page<Sale> sales = saleRepository.findAll(PageRequest.of(0, 10));
        CustomPageDTO<SaleDTO> salesDTO = new CustomPageDTO<>();
        salesDTO.setCustomPage(
                new CustomPage(sales.getTotalElements(), sales.getTotalPages(),
                sales.getNumber(), sales.getSize())
                );

        sales.forEach((sale) -> {
            salesDTO.addContent(ObjectMapper.saleToDTO(sale));
        });
        return salesDTO;
    }
}
