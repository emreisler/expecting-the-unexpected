package com.example.expectingtheunexpected.converter;

import com.example.expectingtheunexpected.entity.OrderEntity;
import com.example.expectingtheunexpected.payload.OrderDTO;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class OrderConverter {

    public static OrderDTO toDto(OrderEntity entity){
        return new OrderDTO(entity.getOrderId(),entity.getCustomerId(),entity.getProductId(),entity.getQuantity());
    }

    public static OrderEntity toEntity(OrderDTO dto) {
        OrderEntity entity = new OrderEntity();
        entity.setOrderId(dto.getOrderId());
        entity.setCustomerId(dto.getCustomerId());
        entity.setProductId(dto.getProductId());
        entity.setQuantity(dto.getQuantity());
        return entity;
    }

}
