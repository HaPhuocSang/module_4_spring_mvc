package org.example.bai_tap.converter;

import org.example.bai_tap.dto.CategoryDto;
import org.example.bai_tap.entity.Category;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class CategoryDtoToCategoryConverter implements Converter<CategoryDto, Category> {
    @Override
    public Category convert(CategoryDto categoryDto) {
        return new Category(categoryDto.getId(), categoryDto.getName(), null);
    }
}
