package org.example.bai_tap.repository;

import org.example.bai_tap.entity.Blog;

import java.util.List;

public interface IBlogRepository {
    List<Blog> findAll();

    Blog findById(Integer id);

    boolean save(Blog blog);

    boolean remove(Integer id);
}
