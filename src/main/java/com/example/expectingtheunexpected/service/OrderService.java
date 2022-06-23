package com.example.expectingtheunexpected.service;

import com.example.expectingtheunexpected.payload.OrderDTO;
import com.example.expectingtheunexpected.payload.OrderRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    public List<OrderDTO> getOrders() {
        return null;
    }

    public void createOrder(OrderRequest orderRequest) {
    }

    public void deleteOrder(String id) {
    }
}
