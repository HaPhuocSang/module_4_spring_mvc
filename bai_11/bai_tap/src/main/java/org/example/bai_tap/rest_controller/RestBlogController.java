package org.example.bai_tap.rest_controller;

import org.example.bai_tap.dto.BlogDto;
import org.example.bai_tap.service.blog.IBlogService;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/blogs")
public class RestBlogController {
    private final IBlogService blogService;

    public RestBlogController(IBlogService blogService) {
        this.blogService = blogService;
    }

    @GetMapping
    public ResponseEntity<Page<BlogDto>> index(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "6") Integer size, @RequestParam(defaultValue = "desc") String direction) {
        Page<BlogDto> blogs = blogService.findALl(page, size, direction);
        return ResponseEntity.ok(blogs);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BlogDto> blogDetail(@PathVariable("id") Long id) {
        Optional<BlogDto> blog = blogService.findById(id);
        return blog.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
}
