package com.example.expectingtheunexpected.repository;

import com.example.expectingtheunexpected.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<ProductEntity,Long> {
}
