package com.irvin.pos.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.irvin.pos.dtos.CustomPageDTO;
import com.irvin.pos.dtos.CustomerDTO;
import com.irvin.pos.exceptions.EntityNotFoundException;
import com.irvin.pos.services.CustomerService;

@RestController()
@RequestMapping("/api/customers")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping()
    public ResponseEntity<CustomPageDTO<CustomerDTO>> getAllCustomers() {
        return ResponseEntity.ok(customerService.getAllCustomers());
    }

    @PostMapping("/create")
    public CustomerDTO createCustomer(@RequestBody CustomerDTO customer) throws Exception {
        return customerService.createCustomer(customer);
    }

    @GetMapping("/identification/{identification}")
    public ResponseEntity<CustomerDTO> getCustomerById(@PathVariable String identification) throws EntityNotFoundException {
        return ResponseEntity.ok(customerService.getCustomerByIdentification(identification));
    }

    @GetMapping("/email/{email}")
    public ResponseEntity<CustomerDTO> getCustomerByEmail(@PathVariable String email) throws EntityNotFoundException {
        return ResponseEntity.ok(customerService.getCustomerByEmail(email));
    }

    @GetMapping("/phone/{phoneNumber}")
    public ResponseEntity<CustomerDTO> getCustomerByPhoneNumber(@PathVariable String phoneNumber) throws EntityNotFoundException {
        return ResponseEntity.ok(customerService.getCustomerByPhoneNumber(phoneNumber));
    }

    @org.springframework.web.bind.annotation.PutMapping("/update")
    public ResponseEntity<CustomerDTO> updateCustomer(@RequestBody CustomerDTO customer) throws EntityNotFoundException {
        return ResponseEntity.ok(customerService.updateCustomer(customer));
    }

    @org.springframework.web.bind.annotation.DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteCustomer(@PathVariable long id) {
        customerService.deleteCustomer(id);
        return ResponseEntity.ok().build();
    }
}
