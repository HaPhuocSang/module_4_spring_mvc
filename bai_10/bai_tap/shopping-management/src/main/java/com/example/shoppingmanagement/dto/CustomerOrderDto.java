package com.example.shoppingmanagement.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CustomerOrderDto {
    private Long id;
    @NotBlank(message = "Vui lòng nhập tên người nhận!")
    private String receiverName;
    @NotBlank(message = "Vui lòng nhập số điện thoại liên lạc!")
    @Pattern(regexp = "^0[0-9]{9}$", message = "Số điện thoại không hợp lệ!")
    private String phone;
    @NotBlank(message = "Vui lòng nhập địa chỉ giao hàng!")
    private String address;
    @NotBlank(message = "Phương thức thanh toán không hợp lệ!")
    private String paymentMethod;
    private String status;
}
