package com.irvin.pos.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import com.irvin.pos.entities.Customer;
import com.irvin.pos.exceptions.PropertyAlreadyExistException;
import com.irvin.pos.repositories.CustomerRepository;

@Service
public class CustomerService {

    @Autowired
    CustomerRepository customerRepository;
    
    public Customer createCustomer(Customer customer) throws PropertyAlreadyExistException {
        if (customerRepository.getByIdentification(customer.getIdentification()) != null

        ) {
            throw new PropertyAlreadyExistException("identification", String.valueOf(customer.getIdentification()));
        } else if (customerRepository.getByPhoneNumber(customer.getPhoneNumber()) != null) {
            throw new PropertyAlreadyExistException("phone_number", customer.getPhoneNumber());
        } else if (customerRepository.getByEmail(customer.getEmail()) != null) {
            throw new PropertyAlreadyExistException("email", customer.getEmail());
        }
        return customerRepository.save(customer);
    }
    
    public Customer updateCustomer(Customer customer){
        return customerRepository.save(customer);
    }

    public void deleteCustomer(long id){
        customerRepository.deleteById(id);
    }

    public Page<Customer> getAllCustomers(){
        Page<Customer> peoplePage =customerRepository.findAll(PageRequest.of(0, 10));
        return peoplePage;
    }
}
