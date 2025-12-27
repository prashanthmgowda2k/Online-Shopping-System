package com.oss.productcatalog.DTO;

import com.oss.productcatalog.entity.Product;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class ProductResponseDto {
    private Long id;
    @NotBlank
    private String name;
    private String description;
    private String brand;
    @NotNull
    private BigDecimal price;
    @NotNull
    private Integer quantity;
    private String categoryName;
    private Double averageRating;
    private Integer reviewCount;
    @NotNull
    private Long categoryId;

//    private ProductResponseDto mapToDto(Product product) {
//        ProductResponseDto dto = new ProductResponseDto();
//        dto.setId(product.getId());
//        dto.setName(product.getName());
//        dto.setDescription(product.getDescription());
//        dto.setBrand(product.getBrand());
//        dto.setPrice(product.getPrice());
//        dto.setQuantity(product.getQuantity());
//        dto.setAverageRating(product.getAverageRating());
//        dto.setReviewCount(product.getReviewCount());
//        dto.setCategoryName(product.getCategory().getName());
//        return dto;
//    }


}
