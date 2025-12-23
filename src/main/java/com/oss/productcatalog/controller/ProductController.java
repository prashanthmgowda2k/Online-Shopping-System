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

import java.math.BigDecimal;
import java.util.Arrays;

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
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {

        Pageable pageable = PageRequest.of(page, size);
        return ResponseEntity.ok(productService.getAllProducts(pageable));
    }

    @GetMapping
    public ResponseEntity<Page<ProductResponseDto>> searchProducts(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) Long categoryId,
            @RequestParam(required = false) BigDecimal minPrice,
            @RequestParam(required = false) BigDecimal maxPrice,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "id,asc") String[] sort) {




//        GET /api/products?sort=price,asc
//        GET /api/products?sort=price,desc
//        GET /api/products?sort=name,asc
//        GET /api/products?categoryId=1&sort=price,desc

        Sort sortObj = Sort.by(
                Arrays.stream(sort)
                        .map(s -> s.split(","))
                        .map(arr -> new Sort.Order(
                                Sort.Direction.fromString(arr[1]), arr[0]))
                        .toList()
        );

        Pageable pageable = PageRequest.of(page, size, sortObj);

        return ResponseEntity.ok(
                productService.searchProducts(
                        name, categoryId, minPrice, maxPrice, pageable
                )
        );
    }
}

