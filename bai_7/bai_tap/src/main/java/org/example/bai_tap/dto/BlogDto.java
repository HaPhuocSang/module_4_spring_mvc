package org.example.bai_tap.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.*;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class BlogDto {
    private Long id;
    @NotBlank(message = "Vui lòng nhập tiêu đề bài viết!")
    private String title;
    @NotBlank(message = "Vui lòng nhập nội dung bài viết!")
    private String content;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    @NotNull(message = "Vui lòng chọn loại bài viết!")
    private Long categoryId;
    private String categoryName;

    public BlogDto(Long id, String title, String content, Long categoryId, String categoryName) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.categoryId = categoryId;
        this.categoryName = categoryName;
    }
}
