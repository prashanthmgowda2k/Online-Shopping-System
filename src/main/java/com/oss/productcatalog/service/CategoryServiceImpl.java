package com.oss.productcatalog.service;

import com.oss.productcatalog.DTO.CategoryRequestDto;
import com.oss.productcatalog.DTO.CategoryResponseDto;
import com.oss.productcatalog.entity.Category;
import com.oss.productcatalog.exception.ResourceNotFoundException;
import com.oss.productcatalog.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    @Override
    public Category createCategory(CategoryRequestDto dto) {

        if (categoryRepository.existsByName(dto.getName())) {
            throw new RuntimeException("Category already exists");
        }

        Category category = new Category();
        category.setName(dto.getName());

        return categoryRepository.save(category);
    }

    @Override
    public List<CategoryResponseDto> getAllCategories() {
        return categoryRepository.findAll()
                .stream()
                .map(cat -> new CategoryResponseDto(
                        cat.getId(),
                        cat.getName()
                ))
                .toList();
    }

    public Category getCategoryById(Long id) {
        return categoryRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Category not found with id = " + id));
    }
}
