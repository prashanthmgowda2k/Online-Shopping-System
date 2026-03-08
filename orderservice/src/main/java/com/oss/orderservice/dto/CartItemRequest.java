package com.oss.orderservice.dto;

import lombok.Data;

@Data
public class CartItemRequest {

    private Long productID;
    private Integer quantity;
}
