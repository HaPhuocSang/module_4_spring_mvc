package org.example.bai_tap.rest_controller;

import org.example.bai_tap.dto.BlogDto;
import org.example.bai_tap.dto.CategoryDto;
import org.example.bai_tap.service.blog.IBlogService;
import org.example.bai_tap.service.category.ICategoryService;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/categories")
public class RestCategoryController {
    private final ICategoryService categoryService;
    private final IBlogService blogService;

    public RestCategoryController(ICategoryService categoryService, IBlogService blogService) {
        this.categoryService = categoryService;
        this.blogService = blogService;
    }

    @GetMapping
    public ResponseEntity<Iterable<CategoryDto>> index() {
        Iterable<CategoryDto> categories = categoryService.findAll();
        return ResponseEntity.ok(categories);
    }

    @GetMapping("/{id}/blogs")
    public ResponseEntity<Page<BlogDto>> category(@PathVariable("id") Long id, @RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "6") Integer size, @RequestParam(defaultValue = "desc") String direction) {
        if (categoryService.findById(id).isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        Page<BlogDto> blogs = blogService.findByCategoryId(id, page, size, direction);
        return ResponseEntity.ok(blogs);
    }
}
