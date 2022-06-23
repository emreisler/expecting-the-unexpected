package com.example.expectingtheunexpected.controller;

import com.example.expectingtheunexpected.payload.OrderDTO;
import com.example.expectingtheunexpected.payload.OrderRequest;
import com.example.expectingtheunexpected.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping("/{customerId}")
    public List<OrderDTO> getOrders(@PathVariable("customerId") String customerId){
        return orderService.getOrders();

    }

    @PostMapping
    public void createOrder(@Valid @RequestBody OrderRequest orderRequest){
        orderService.createOrder(orderRequest);
    }

    @DeleteMapping("/{id}")
    public void deleteOrder(@PathVariable("id") String id){
        orderService.deleteOrder(id);
    }
}
