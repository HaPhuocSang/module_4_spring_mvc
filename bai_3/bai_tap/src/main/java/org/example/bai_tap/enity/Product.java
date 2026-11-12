package org.example.bai_tap.enity;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public class Product {
    private Integer id;
    @NotBlank(message = "Vui lòng nhập tên sản phẩm")
    private String productName;
    @NotNull(message = "Vui lòng nhập giá hàng!")
    @Positive(message = "Giá hàng sản phẩm phải là số dương!")
    @Min(value = 10000, message = "Giá hàng thấp nhất là 10.000 VNĐ!")
    private Double price;
    @NotBlank(message = "Vui lòng nhập mô tả sản phầm!")
    private String description;
    @NotBlank(message = "Vui lòng nhập tên nhà sản xuất!")
    private String manufacturer;

    public Product() {
    }

    public Product(String productName, Double price, String description, String manufacturer) {
        this.productName = productName;
        this.price = price;
        this.description = description;
        this.manufacturer = manufacturer;
    }

    public Product(Integer id, String productName, Double price, String description, String manufacturer) {
        this.id = id;
        this.productName = productName;
        this.price = price;
        this.description = description;
        this.manufacturer = manufacturer;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }
}
