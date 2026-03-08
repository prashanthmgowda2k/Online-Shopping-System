package com.oss.orderservice.service;


import com.oss.orderservice.clients.ProductServiceClient;
import com.oss.orderservice.clients.UserServiceClient;
import com.oss.orderservice.dto.CartItemRequest;
import com.oss.orderservice.dto.ProductResponseDto;
import com.oss.orderservice.dto.UserResponseDto;
import com.oss.orderservice.repository.CartRepository;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class CartService {


    private final ProductServiceClient productServiceClient;
    private final UserServiceClient userServiceClient;

    @CircuitBreaker(name = "productservice")
    public boolean addTocart(String userId, CartItemRequest request) {

        ProductResponseDto productResponse = productServiceClient.getProductDetails(String.valueOf(request.getProductID()));
        if(productResponse == null){
            return false;
        }

        UserResponseDto userResponse = userServiceClient.getUserDetails(userId);
        if(userResponse == null){
            return false;
        }

        if(productResponse.getQuantity() < request.getQuantity()){
            return false;
        }


        return true;


    }
}
