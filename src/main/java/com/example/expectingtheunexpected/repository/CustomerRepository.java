package com.example.expectingtheunexpected.repository;

import com.example.expectingtheunexpected.entity.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<CustomerEntity,Long> {
}
