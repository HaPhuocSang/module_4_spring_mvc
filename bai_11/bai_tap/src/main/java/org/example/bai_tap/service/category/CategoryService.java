package org.example.bai_tap.service.category;

import org.example.bai_tap.converter.CategoryDtoToCategoryConverter;
import org.example.bai_tap.converter.CategoryToCategoryDtoConverter;
import org.example.bai_tap.dto.CategoryDto;
import org.example.bai_tap.entity.Category;
import org.example.bai_tap.repository.ICategoryRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class CategoryService implements ICategoryService {
    private final ICategoryRepository categoryRepository;
    private final CategoryToCategoryDtoConverter categoryToCategoryDtoConverter;
    private final CategoryDtoToCategoryConverter categoryDtoToCategoryConverter;

    public CategoryService(ICategoryRepository categoryRepository, CategoryToCategoryDtoConverter categoryToCategoryDtoConverter, CategoryDtoToCategoryConverter categoryDtoToCategoryConverter) {
        this.categoryRepository = categoryRepository;
        this.categoryToCategoryDtoConverter = categoryToCategoryDtoConverter;
        this.categoryDtoToCategoryConverter = categoryDtoToCategoryConverter;
    }

    @Override
    public Iterable<CategoryDto> findAll() {
        List<Category> allCategories = categoryRepository.findAll();
        List<CategoryDto> categoryDtos = new ArrayList<>();
        for (Category category : allCategories) {
            categoryDtos.add(categoryToCategoryDtoConverter.convert(category));
        }
        return categoryDtos;
    }

    @Override
    public Optional<CategoryDto> findById(Long id) {
        return categoryRepository.findById(id).map(categoryToCategoryDtoConverter::convert);
    }

    @Override
    public boolean save(CategoryDto categoryDto) {
        if (categoryDto.getId() != null) {
            return false;
        }
        categoryRepository.save(categoryDtoToCategoryConverter.convert(categoryDto));
        return true;
    }

    @Override
    public boolean update(CategoryDto categoryDto) {
        if (categoryRepository.findById(categoryDto.getId()).isPresent()) {
            categoryRepository.save(Objects.requireNonNull(categoryDtoToCategoryConverter.convert(categoryDto)));
            return true;
        }
        return false;
    }

    @Override
    public boolean delete(Long id) {
        if (categoryRepository.findById(id).isPresent()) {
            categoryRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
