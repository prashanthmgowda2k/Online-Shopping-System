package com.oss.productcatalog.service;

import com.oss.productcatalog.DTO.ProductRequestDto;
import com.oss.productcatalog.DTO.ProductResponseDto;
import com.oss.productcatalog.entity.Category;
import com.oss.productcatalog.entity.Product;
import com.oss.productcatalog.repository.CategoryRepository;
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
    private final CategoryRepository categoryRepository;

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

        Category category = categoryRepository.findById(dto.getCategoryId())
                .orElseThrow(() -> new RuntimeException("Category not found"));

        if (categoryRepository.existsByParentCategory(category)) {
            throw new RuntimeException("Product can only be added to leaf category");
        }

        Product product = new Product();
        product.setName(dto.getName());
        product.setDescription(dto.getDescription());
        product.setBrand(dto.getBrand());
        product.setPrice(dto.getPrice());
        product.setQuantity(dto.getQuantity());
        product.setCategory(category);
        product.setIsActive(true);
        product.setAverageRating(0.0);
        product.setReviewCount(0);

        return mapToDto(productRepository.save(product));
    }

    @Override
    public ProductResponseDto getProductById(Long productId) {

        Product product = productRepository.findById(productId)
                .filter(Product::getIsActive)
                .orElseThrow(() -> new RuntimeException("Product not found"));

        return mapToDto(product);
    }

    @Override
    public Page<ProductResponseDto> getAllProducts(Pageable pageable) {
        return productRepository
                .findByIsActiveTrue(pageable)
                .map(this::mapToDto);
    }

    private ProductResponseDto mapToDto(Product product) {
        ProductResponseDto dto = new ProductResponseDto();
        dto.setId(product.getId());
        dto.setName(product.getName());
        dto.setDescription(product.getDescription());
        dto.setBrand(product.getBrand());
        dto.setPrice(product.getPrice());
        dto.setQuantity(product.getQuantity());
        dto.setAverageRating(product.getAverageRating());
        dto.setReviewCount(product.getReviewCount());
        dto.setCategoryName(product.getCategory().getName());
        return dto;
    }
}

