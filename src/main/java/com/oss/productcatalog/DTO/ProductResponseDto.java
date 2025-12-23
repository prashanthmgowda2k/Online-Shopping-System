package com.oss.productcatalog.DTO;

import lombok.*;

import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class ProductResponseDto {
    private Long id;
    private String name;
    private String description;
    private String brand;
    private BigDecimal price;
    private Integer quantity;
    private String categoryName;
    private Double averageRating;
    private Integer reviewCount;


}
