package com.example.expectingtheunexpected.converter;

import com.example.expectingtheunexpected.entity.CustomerEntity;
import com.example.expectingtheunexpected.payload.CustomerDTO;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class CustomerConverter {
    public static CustomerDTO toDto(CustomerEntity entity){
        return new CustomerDTO(entity.getCustomerId(), entity.getName(), entity.getEmail());
    }

    public static CustomerEntity toEntity(CustomerDTO dto){
        CustomerEntity entity = new CustomerEntity();
        entity.setCustomerId(dto.getCustomerId());
        entity.setName(dto.getName());
        entity.getEmail();
        return entity;
    }
}
