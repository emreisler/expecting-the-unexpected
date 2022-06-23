package com.example.expectingtheunexpected.service;

import com.example.expectingtheunexpected.entity.CustomerEntity;
import com.example.expectingtheunexpected.exception.MarketRuntimeException;
import com.example.expectingtheunexpected.payload.CustomerDTO;
import com.example.expectingtheunexpected.repository.CustomerRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CustomerServiceTest {

    @InjectMocks
    private CustomerService customerService;

    @Mock
    private CustomerRepository customerRepository;

    @Test
    void should_return_customer_dto(){
        //Prepare
        CustomerDTO dto = new CustomerDTO("456","testName","test@test.com");
        CustomerEntity entity = new CustomerEntity();
        entity.setCustomerId("456");
        entity.setName("testName");
        entity.setEmail("test@test.com");
        when(customerRepository.findById(456L)).thenReturn(Optional.of(entity));
        when(customerRepository.save(entity)).thenReturn(entity);

        //Run
        CustomerDTO returnDto = customerService.updateCustomer("456",dto);

        //Assert
        assertEquals("456", returnDto.getCustomerId());
    }

    @Test
    void should_throw_customer_not_found_exception(){
        //Prepare
        when(customerRepository.findById(123L)).thenReturn(Optional.empty());

        //Run and assert
        assertThrows(MarketRuntimeException.class,
                () -> customerService.updateCustomer("123", new CustomerDTO()));
    }
}
