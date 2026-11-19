package org.example.bai_tap.service.blog;

import org.example.bai_tap.dto.BlogDto;
import org.springframework.data.domain.Page;

import java.util.Optional;

public interface IBlogService {
    Page<BlogDto> search(String keyword, Integer page, Integer size, String direction);
    Page<BlogDto> findALl(Integer page, Integer size, String direction);
    Page<BlogDto> findByCategoryId(Long categoryId, Integer page, Integer size, String direction);
    Optional<BlogDto> findById(Long id);
    boolean save(BlogDto blogDto);
    boolean update(BlogDto blogDto);
    boolean remove(Long id);
}
