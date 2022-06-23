package com.example.expectingtheunexpected.repository;

import com.example.expectingtheunexpected.entity.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<OrderEntity,Long> {
}
