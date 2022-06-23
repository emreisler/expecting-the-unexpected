package com.example.expectingtheunexpected.controller;

import com.example.expectingtheunexpected.payload.CustomerDTO;
import com.example.expectingtheunexpected.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping
    public List<CustomerDTO> getCustomers(){
        return customerService.getCustomers();
    }

    @PostMapping
    public void createCustomer(@Valid @RequestBody CustomerDTO customerDto){
        customerService.createCustomer(customerDto);
    }

    @PutMapping("/{id}")
    public void updateCustomer(@PathVariable("id") String id, @Valid @RequestBody CustomerDTO customerDto){
        customerService.updateCustomer(id,customerDto);
    }

    @DeleteMapping("/{id}")
    public void deleteCustomer(@PathVariable("id") String id){
        customerService.deleteCustomer(id);
    }
}
