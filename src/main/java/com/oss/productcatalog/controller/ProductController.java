package com.oss.productcatalog.controller;

import com.oss.productcatalog.DTO.ProductRequestDto;
import com.oss.productcatalog.DTO.ProductResponseDto;
import com.oss.productcatalog.service.ProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.web.PageableDefault;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
public class ProductController {


    private final ProductService productService;

    // CREATE PRODUCT (Admin)
    @PostMapping("/add")
    public ResponseEntity<ProductResponseDto> createProduct(
            @Valid @RequestBody ProductRequestDto dto) {

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(productService.createProduct(dto));
    }

    // GET PRODUCT BY ID
    @GetMapping("/{id}")
    public ResponseEntity<ProductResponseDto> getProduct(@PathVariable Long id) {

        return ResponseEntity.ok(productService.getProductById(id));
    }

    // GET ALL PRODUCTS (Pagination)
    @GetMapping("/all")
    public ResponseEntity<Page<ProductResponseDto>> getAllProducts(
            @PageableDefault(
                    page = 0,
                    size = 10,
                    sort = "price",
                    direction = Sort.Direction.ASC
            ) Pageable pageable) {

        return ResponseEntity.ok(productService.getAllProducts(pageable));
    }


//    GET /api/products
//    GET /api/products?page=0&size=5
//    GET /api/products?sort=price,asc
//    GET /api/products?page=1&size=10&sort=name,desc
    @GetMapping
    public ResponseEntity<Page<ProductResponseDto>> searchProducts(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) Long categoryId,
            @RequestParam(required = false) BigDecimal minPrice,
            @RequestParam(required = false) BigDecimal maxPrice,
            Pageable pageable) {

        return ResponseEntity.ok(
                productService.searchProducts(
                        name, categoryId, minPrice, maxPrice, pageable
                )
        );
    }
}

