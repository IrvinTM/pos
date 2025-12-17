package com.irvin.pos.services;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.irvin.pos.dtos.CustomPageDTO;
import com.irvin.pos.dtos.SaleDTO;
import com.irvin.pos.entities.CashRegister;
import com.irvin.pos.entities.Customer;
import com.irvin.pos.entities.Product;
import com.irvin.pos.entities.Sale;
import com.irvin.pos.entities.SaleItem;
import com.irvin.pos.exceptions.EntityNotFoundException;
import com.irvin.pos.repositories.CashRegisterRepository;
import com.irvin.pos.repositories.CustomerRepository;
import com.irvin.pos.repositories.ProductRepository;
import com.irvin.pos.repositories.SaleItemRepository;
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

    @Autowired
    private SaleItemRepository saleItemRepository;

    @Autowired
    private ProductRepository productRepository;


    // TODO fix exc not being catched by the handler
    // TODO 
    public SaleDTO addSale(SaleDTO saleDTO) throws EntityNotFoundException, NoSuchElementException {

        Sale sale = new Sale();

        Optional<Customer> customer = customerRepository.findById(saleDTO.getCustomerID());
        if (customer.isEmpty()) {
            throw new EntityNotFoundException("Custosmer");
        }
        Optional<CashRegister> cashRegister = cashRegisterRepository.findById(saleDTO.getCashRegisterID());
        if (cashRegister.isEmpty()) {
            throw new EntityNotFoundException("Cash Register");
        }

        List<SaleItem> items = new ArrayList<SaleItem>();
        saleDTO.getItems().forEach(item -> {
            SaleItem i = new SaleItem();
            //TODO convert saleItem DTOS to saleItems
            i.setPriceAtSale(item.getPriceAtSale());

            Optional<Product> prodOptional = productRepository.findById(item.getProductId());
            
            i.setProduct(prodOptional.orElseThrow(() -> new EntityNotFoundException("Product")));
            i.setQuantity(item.getQuantity());
            //i.setSale(saleRepository.getReferenceById(item.getId()));
           //
           //TODO set date
            items.add(i);
        
        sale.setCashRegister(cashRegister.get());
        sale.setCustomer(customer.get());
        sale.setItems(items);
        sale.setDiscount(saleDTO.getDiscount());
        sale.setTotal(saleDTO.getTotal());
           
        });

        Sale sal = saleRepository.save(sale);

        return ObjectMapper.saleToDTO(sal); 
       }

    public void deleteSale(long id) {
        saleRepository.deleteById(id);
    }

    public CustomPageDTO<SaleDTO> getAllSales() {
        Page<Sale> sales = saleRepository.findAll(PageRequest.of(0, 100));
        CustomPageDTO<SaleDTO> salesDTO = new CustomPageDTO<>();
        salesDTO.setCustomPage(
                new CustomPage(sales.getTotalElements(), sales.getTotalPages(),
                        sales.getNumber(), sales.getSize()));

        sales.forEach((sale) -> {
            salesDTO.addContent(ObjectMapper.saleToDTO(sale));
        });
        return salesDTO;
    }
}
