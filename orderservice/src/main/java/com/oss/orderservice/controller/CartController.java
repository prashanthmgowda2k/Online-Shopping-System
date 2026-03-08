package com.oss.orderservice.controller;


import com.oss.orderservice.dto.CartItemRequest;
import com.oss.orderservice.service.CartService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/cart")
@RequiredArgsConstructor
public class CartController {

    private final CartService cartService;

    @PostMapping
    public ResponseEntity<String> addToCart(@RequestHeader("X-User-ID") String userId,
                                            @RequestBody CartItemRequest request) {
        if(!cartService.addTocart(userId, request)){
            return ResponseEntity.badRequest().body("Product out of Stock or user not found or product out of stock");
        }
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
