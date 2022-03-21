package com.example.javaspring.mapper;

import com.example.javaspring.dto.CategoryDto;
import com.example.javaspring.model.Category;
import org.springframework.stereotype.Component;

@Component
public class CategoryMapper {
    public CategoryDto toCategoryDto(Category category){
        CategoryDto categoryDto = new CategoryDto();
        categoryDto.setId(category.getId());
        categoryDto.setNameCategory(category.getNameCategory());

        return categoryDto;
    }
    public Category toCategory(CategoryDto categoryDto){
        Category category = new Category();
        category.setNameCategory(categoryDto.getNameCategory());
        return category;
    }
}
