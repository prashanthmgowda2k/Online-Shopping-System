package com.oss.productcatalog.service;

import com.oss.productcatalog.DTO.ProductRequestDto;
import com.oss.productcatalog.DTO.ProductResponseDto;
import com.oss.productcatalog.entity.Product;
import com.oss.productcatalog.repository.ProductRepository;
import com.oss.productcatalog.repository.spec.ProductSpecification;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    @Override
    public Page<ProductResponseDto> searchProducts(
            String name,
            Long categoryId,
            BigDecimal minPrice,
            BigDecimal maxPrice,
            Pageable pageable) {

        Specification<Product> spec =
                ProductSpecification.search(
                        name, categoryId, minPrice, maxPrice
                );

        return productRepository.findAll(spec, pageable)
                .map(this::mapToDto);
    }

    @Override
    public ProductResponseDto createProduct(ProductRequestDto dto) {
        // existing logic you already have
        return null;
    }

    @Override
    public ProductResponseDto getProductById(Long productId) {
        // existing logic you already have
        return null;
    }

    @Override
    public Page<ProductResponseDto> getAllProducts(Pageable pageable) {
        // existing logic you already have
        return null;
    }

    private ProductResponseDto mapToDto(Product product) {
        ProductResponseDto dto = new ProductResponseDto();
        dto.setId(product.getId());
        dto.setName(product.getName());
        dto.setPrice(product.getPrice());
        return dto;
    }
}
