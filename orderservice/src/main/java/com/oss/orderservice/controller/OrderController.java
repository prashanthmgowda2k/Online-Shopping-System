package com.oss.orderservice.controller;

import com.oss.orderservice.dto.OrderRequest;
import com.oss.orderservice.entity.Order;
import com.oss.orderservice.repository.OrderRepository;
import com.oss.orderservice.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/order")
public class OrderController {

    private final OrderService orderService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public String placeOrder(@RequestBody  OrderRequest orderRequest){
        orderService.placeOrder(orderRequest);
        return "order placed sucessfully!";
    }

    @GetMapping("/all")
    public List<Order> orders(){
        return orderService.getOrders();
    }
}
