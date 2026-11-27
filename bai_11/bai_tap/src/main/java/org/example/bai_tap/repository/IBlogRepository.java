package org.example.bai_tap.repository;

import org.example.bai_tap.entity.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IBlogRepository extends IBaseRepository<Blog,Long> {
    Page<Blog> findByTitleContaining(String keyword, Pageable pageable);
    Page<Blog> findByCategoryId(Long categoryId, Pageable pageable);
}
