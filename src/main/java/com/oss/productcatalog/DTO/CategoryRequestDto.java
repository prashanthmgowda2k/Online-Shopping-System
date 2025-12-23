package com.oss.productcatalog.DTO;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class CategoryRequestDto {

    @NotBlank
    private String name;
    private Long id;
}
