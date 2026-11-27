package org.example.bai_tap.converter;

import org.example.bai_tap.dto.CategoryDto;
import org.example.bai_tap.entity.Category;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class CategoryToCategoryDtoConverter implements Converter<Category, CategoryDto> {

    @Override
    public CategoryDto convert(Category category) {
        return new CategoryDto(category.getId(), category.getName());
    }
}
