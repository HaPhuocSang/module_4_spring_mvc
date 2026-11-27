package org.example.bai_tap.service.category;

import org.example.bai_tap.dto.CategoryDto;
import org.example.bai_tap.entity.Category;

import java.util.Optional;

public interface ICategoryService {
    Iterable<CategoryDto> findAll();
    Optional<CategoryDto> findById(Long id);
    boolean save(CategoryDto category);
    boolean update(CategoryDto category);
    boolean delete(Long id);
}
