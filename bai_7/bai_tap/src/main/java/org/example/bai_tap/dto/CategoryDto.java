package org.example.bai_tap.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class CategoryDto {
    private Long id;
    @NotBlank(message = "Tên danh mục không được để trống")
    private String name;
}
