package org.example.bai_tap.converter;

import org.example.bai_tap.dto.BlogDto;
import org.example.bai_tap.entity.Blog;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class BlogToBlogDtoConverter implements Converter<Blog, BlogDto> {
    @Override
    public BlogDto convert(Blog blog) {
        if (blog == null) {
            throw new IllegalArgumentException("Blog không được null");
        }
        return new BlogDto(blog.getId(), blog.getTitle(), blog.getContent(), blog.getCreatedAt(), blog.getUpdatedAt(), blog.getCategory().getId(), blog.getCategory().getName());
    }
}
