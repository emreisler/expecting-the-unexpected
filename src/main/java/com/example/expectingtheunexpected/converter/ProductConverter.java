package com.example.expectingtheunexpected.converter;

import com.example.expectingtheunexpected.entity.ProductEntity;
import com.example.expectingtheunexpected.payload.ProductDTO;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ProductConverter {
    public static ProductDTO toDto(ProductEntity entity){
        return new ProductDTO(entity.getProductId(), entity.getName(), entity.getQuantity());
    }

    public static ProductEntity toEntity(ProductDTO dto){
        ProductEntity entity = new ProductEntity();
        entity.setProductId(dto.getProductId());
        entity.setName(dto.getName());
        entity.setQuantity(dto.getQuantity());
        return entity;
    }
}
