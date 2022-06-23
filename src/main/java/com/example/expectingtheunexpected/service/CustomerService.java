package com.example.expectingtheunexpected.service;

import com.example.expectingtheunexpected.converter.CustomerConverter;
import com.example.expectingtheunexpected.entity.CustomerEntity;
import com.example.expectingtheunexpected.exception.CustomerNotFoundException;
import com.example.expectingtheunexpected.payload.CustomerDTO;
import com.example.expectingtheunexpected.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public List<CustomerDTO> getCustomers() {
        return customerRepository.findAll().stream()
                .map(CustomerConverter::toDto)
                .collect(Collectors.toList());
    }

    public void createCustomer(CustomerDTO customerDto) {
        customerRepository.save(CustomerConverter.toEntity(customerDto));
    }

    public CustomerDTO updateCustomer(String id, CustomerDTO customerDto) {
        CustomerEntity entity = customerRepository.findById(Long.parseLong(id))
                .orElseThrow(CustomerNotFoundException::new);
        entity.setName(customerDto.getName());
        entity.setEmail(customerDto.getEmail());
        return CustomerConverter.toDto(customerRepository.save(entity));
    }

    public void deleteCustomer(String id) {
        customerRepository.deleteById(Long.parseLong(id));
    }
}
