package org.example.bai_tap.converter;

import org.example.bai_tap.dto.BlogDto;
import org.example.bai_tap.entity.Blog;
import org.example.bai_tap.entity.Category;
import org.example.bai_tap.repository.ICategoryRepository;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class BlogDtoToBlogConverter implements Converter<BlogDto, Blog> {
    private final ICategoryRepository categoryRepository;

    public BlogDtoToBlogConverter(ICategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Blog convert(BlogDto blogDto) {
        Category category = categoryRepository.findById(blogDto.getCategoryId()).orElseThrow(() -> new RuntimeException("Không tìm thấy Category"));
        return new Blog(blogDto.getId(), blogDto.getTitle(), blogDto.getContent(), blogDto.getCreatedAt(),blogDto.getUpdatedAt(), category);
    }
}
