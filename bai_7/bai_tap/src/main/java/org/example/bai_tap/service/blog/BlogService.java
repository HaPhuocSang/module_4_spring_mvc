package org.example.bai_tap.service.blog;

import org.example.bai_tap.converter.BlogDtoToBlogConverter;
import org.example.bai_tap.converter.BlogToBlogDtoConverter;
import org.example.bai_tap.dto.BlogDto;
import org.example.bai_tap.entity.Blog;
import org.example.bai_tap.repository.IBlogRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;

@Service
public class BlogService implements IBlogService {
    private final IBlogRepository blogRepository;
    private final BlogDtoToBlogConverter blogDtoToBlogConverter;
    private final BlogToBlogDtoConverter blogToBlogDtoConverter;

    public BlogService(IBlogRepository blogRepository, BlogDtoToBlogConverter blogDtoToBlogConverter, BlogToBlogDtoConverter blogToBlogDtoConverter) {
        this.blogRepository = blogRepository;
        this.blogDtoToBlogConverter = blogDtoToBlogConverter;
        this.blogToBlogDtoConverter = blogToBlogDtoConverter;
    }

    @Override
    public Page<BlogDto> search(String keyword, Integer page, Integer size, String direction) {
        Sort sort = direction.equalsIgnoreCase("asc") ? Sort.by("createdAt").ascending() : Sort.by("createdAt").descending();
        Pageable pageable = PageRequest.of(page, size, sort);
        Page<Blog> blogs = blogRepository.findByTitleContaining(keyword, pageable);
        return blogs.map(blogToBlogDtoConverter::convert);
    }

    @Override
    public Page<BlogDto> findALl(Integer page, Integer size, String direction) {
        Sort sort = direction.equalsIgnoreCase("asc") ? Sort.by("createdAt").ascending() : Sort.by("createdAt").descending();
        Pageable pageable = PageRequest.of(page, size, sort);
        Page<Blog> blogs = blogRepository.findAll(pageable);
        return blogs.map(blogToBlogDtoConverter::convert);
    }

    @Override
    public Page<BlogDto> findByCategoryId(Long categoryId, Integer page, Integer size, String direction) {
        Sort sort = direction.equalsIgnoreCase("asc") ? Sort.by("createdAt").ascending() : Sort.by("createdAt").descending();
        Pageable pageable = PageRequest.of(page, size, sort);
        Page<Blog> blogs = blogRepository.findByCategoryId(categoryId, pageable);
        return blogs.map(blogToBlogDtoConverter::convert);
    }

    @Override
    public Optional<BlogDto> findById(Long id) {
        Optional<Blog> blog = blogRepository.findById(id);
        return blog.map(blogToBlogDtoConverter::convert);
    }

    @Override
    public boolean save(BlogDto blogDto) {
        if (blogDto.getId() != null) {
            return false;
        }
        blogRepository.save(blogDtoToBlogConverter.convert(blogDto));
        return true;
    }

    @Override
    public boolean update(BlogDto blogDto) {
        if (blogRepository.findById(blogDto.getId()).isPresent()) {
            blogRepository.save(Objects.requireNonNull(blogDtoToBlogConverter.convert(blogDto)));
            return true;
        }
        return false;
    }

    @Override
    public boolean remove(Long id) {
        if (blogRepository.findById(id).isPresent()) {
            blogRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
