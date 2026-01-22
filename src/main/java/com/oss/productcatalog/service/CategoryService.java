package com.oss.productcatalog.service;

import com.oss.productcatalog.DTO.CategoryRequestDto;
import com.oss.productcatalog.DTO.CategoryResponseDto;
import com.oss.productcatalog.entity.Category;

import java.util.List;

public interface CategoryService {

    Category createCategory(CategoryRequestDto dto);

    List<CategoryResponseDto> getAllCategories();

    Category getCategoryById(Long id);
}
