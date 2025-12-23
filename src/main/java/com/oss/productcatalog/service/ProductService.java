package com.oss.productcatalog.service;

import com.oss.productcatalog.DTO.ProductRequestDto;
import com.oss.productcatalog.DTO.ProductResponseDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.math.BigDecimal;

public interface ProductService {

    ProductResponseDto createProduct(ProductRequestDto dto);

    ProductResponseDto getProductById(Long productId);

    Page<ProductResponseDto> getAllProducts(Pageable pageable);

    Page<ProductResponseDto> searchProducts(
            String name,
            Long categoryId,
            BigDecimal minPrice,
            BigDecimal maxPrice,
            Pageable pageable
    );
}

