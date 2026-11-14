package org.example.bai_tap.service;

import org.example.bai_tap.dto.BlogDto;
import org.example.bai_tap.entity.Blog;
import org.example.bai_tap.repository.IBlogRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BlogService implements IBlogService {
    private final IBlogRepository blogRepository;

    public BlogService(IBlogRepository blogRepository) {
        this.blogRepository = blogRepository;
    }

    @Override
    public List<BlogDto> findAll() {
        List<BlogDto> blogDtoList = new ArrayList<>();
        List<Blog> blogList = blogRepository.findAll();
        for (Blog blog : blogList) {
            blogDtoList.add(changeBlogDto1(blog));
        }
        return blogDtoList;
    }

    @Override
    public BlogDto findById(Integer id) {
        return changeBlogDto1(blogRepository.findById(id));
    }

    @Override
    public boolean save(BlogDto blogDto) {
        return blogRepository.save(changeBlog2(blogDto));
    }

    @Override
    public boolean remove(Integer id) {
        return blogRepository.remove(id);
    }

    private BlogDto changeBlogDto1(Blog blog) {
        return new BlogDto(blog.getId(), blog.getTitle(), blog.getContent(), blog.getCreatedAt(), blog.getUpdatedAt());
    }

    private BlogDto changeBlogDto2(Blog blog) {
        return new BlogDto(blog.getId(), blog.getTitle(), blog.getContent());
    }

    private Blog changeBlog1(BlogDto blogDto) {
        return new Blog(blogDto.getId(), blogDto.getTitle(), blogDto.getContent(), blogDto.getCreatedAt(), blogDto.getUpdatedAt());
    }

    private Blog changeBlog2(BlogDto blogDto) {
        return new Blog(blogDto.getId(), blogDto.getTitle(), blogDto.getContent());
    }
}
