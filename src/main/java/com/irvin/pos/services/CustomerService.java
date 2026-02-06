package com.irvin.pos.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.irvin.pos.dtos.CustomPageDTO;
import com.irvin.pos.dtos.CustomerDTO;
import com.irvin.pos.entities.Customer;
import com.irvin.pos.exceptions.EntityNotFoundException;
import com.irvin.pos.exceptions.PropertyAlreadyExistException;
import com.irvin.pos.repositories.CustomerRepository;
import com.irvin.pos.utils.CustomPage;
import com.irvin.pos.utils.ObjectMapper;

@Service
public class CustomerService {

    @Autowired
    CustomerRepository customerRepository;

    public CustomerDTO createCustomer(CustomerDTO customerDTO) throws PropertyAlreadyExistException {
        if (customerRepository.findByIdentification(customerDTO.getIdentification()) != null) {
            throw new PropertyAlreadyExistException("identification", String.valueOf(customerDTO.getIdentification()));
        } else if (customerRepository.findByPhoneNumber(customerDTO.getPhoneNumber()) != null) {
            throw new PropertyAlreadyExistException("phone_number", customerDTO.getPhoneNumber());
        } else if (customerRepository.findByEmail(customerDTO.getEmail()) != null) {
            throw new PropertyAlreadyExistException("email", customerDTO.getEmail());
        }
        Customer customer = customerDTO.toEntity();
        return CustomerDTO.fromEntity(customerRepository.save(customer));
    }

    public CustomerDTO updateCustomer(CustomerDTO customerDTO) throws EntityNotFoundException {
        Customer existingCustomer = customerRepository.findById(customerDTO.getId())
                .orElseThrow(() -> new EntityNotFoundException("Customer"));
        
        existingCustomer.setName(customerDTO.getName());
        existingCustomer.setIdentification(customerDTO.getIdentification());
        existingCustomer.setAddress(customerDTO.getAddress());
        existingCustomer.setPhoneNumber(customerDTO.getPhoneNumber());
        existingCustomer.setEmail(customerDTO.getEmail());
        
        return CustomerDTO.fromEntity(customerRepository.save(existingCustomer));
    }

    public void deleteCustomer(long id) {
        customerRepository.deleteById(id);
    }

    public CustomPageDTO<CustomerDTO> getAllCustomers() {
        Page<Customer> peoplePage = customerRepository.findAll(PageRequest.of(0, 10));
        CustomPageDTO<CustomerDTO> page = new CustomPageDTO<>();
        CustomPage p = new CustomPage(peoplePage.getTotalElements(), peoplePage.getTotalPages(), peoplePage.getNumber(),
                peoplePage.getSize());
        page.setCustomPage(p);
        
        List<CustomerDTO> dtos = peoplePage.getContent().stream()
                .map(CustomerDTO::fromEntity)
                .collect(Collectors.toList());
        page.setContent(dtos);
        
        return page;
    }

    public CustomerDTO getCustomerByIdentification(String identification) throws EntityNotFoundException {
        Customer cust = customerRepository.findByIdentification(identification);
        if (cust == null) {
            throw new EntityNotFoundException("Customer");
        }
        return CustomerDTO.fromEntity(cust);
    }

    public CustomerDTO getCustomerByEmail(String email) throws EntityNotFoundException {
        Customer cust = customerRepository.findByEmail(email);
        if (cust == null) {
            throw new EntityNotFoundException("Customer");
        }
        return CustomerDTO.fromEntity(cust);
    }

    public CustomerDTO getCustomerByPhoneNumber(String phoneNumber) throws EntityNotFoundException {
        Customer cust = customerRepository.findByPhoneNumber(phoneNumber);
        if (cust == null) {
            throw new EntityNotFoundException("Customer");
        }
        return CustomerDTO.fromEntity(cust);
    }
    
    public CustomerDTO getCustomerById(Long id){
        Optional<Customer> cust = customerRepository.findById(id); 
        if(cust.get() == null){
            throw new EntityNotFoundException("Customer");
        }
        return CustomerDTO.fromEntity(cust.get());
    }
}
