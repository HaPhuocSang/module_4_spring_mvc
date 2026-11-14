package org.example.bai_tap.dto;

import jakarta.validation.constraints.NotBlank;

import java.time.LocalDate;

public class BlogDto {
    private Integer id;
    @NotBlank(message = "Vui lòng nhập tiêu đề bài viết!")
    private String title;
    @NotBlank(message = "Vui lòng nhập nội dung bài viết!")
    private String content;
    private LocalDate createdAt;
    private LocalDate updatedAt;

    public BlogDto() {
    }

    public BlogDto(Integer id, String title, String content) {
        this.id = id;
        this.title = title;
        this.content = content;
    }

    public BlogDto(Integer id, String title, String content, LocalDate createdAt, LocalDate updatedAt) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDate createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDate getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDate updatedAt) {
        this.updatedAt = updatedAt;
    }
}
