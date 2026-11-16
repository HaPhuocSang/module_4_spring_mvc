package org.example.productmanagegment.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class ProductDto {
    private Long id;
    @NotBlank(message = "Vui lòng nhập tên sản phẩm!")
    private String name;
    @NotNull(message = "Vui lòng nhập giá sản phẩm!")
    private Double price;
    @NotBlank(message = "Vui lòng nhập mô tả sản phẩm!")
    private String description;
    @NotBlank(message = "Vui lòng nhập tên nhà sản xuất!")
    private String manufacturer;

    public ProductDto(String name, Double price, String description, String manufacturer) {
        this.name = name;
        this.price = price;
        this.description = description;
        this.manufacturer = manufacturer;
    }
}
