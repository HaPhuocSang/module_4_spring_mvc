package org.example.bai_tap.service;

import org.example.bai_tap.dto.BlogDto;

import java.util.List;

public interface IBlogService {
    List<BlogDto> findAll();

    BlogDto findById(Integer id);

    boolean save(BlogDto blog);

    boolean remove(Integer id);
}
