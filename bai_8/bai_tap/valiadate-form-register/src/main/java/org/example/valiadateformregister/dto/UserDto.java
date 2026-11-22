package org.example.valiadateformregister.dto;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.valiadateformregister.validator.email.UniqueEmail;
import org.example.valiadateformregister.validator.phonenumber.UniquePhoneNumber;
import org.example.valiadateformregister.validator.repassword.PasswordMatch;
import org.example.valiadateformregister.validator.username.UniqueUsername;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@PasswordMatch(message = "Mật khẩu nhập lại không khớp")
public class UserDto {
    private Long id;
    @NotBlank(message = "Username không được để trống!")
    @UniqueUsername(message = "Username đã tồn tại!")
    private String username;
    @NotBlank(message = "Password không được để trống")
    @Size(min = 6, message = "Password phải có ít nhất 6 ký tự")
    private String password;
    @NotBlank(message = "RePassword không được để trống!")
    private String confirmPassword;
    @NotBlank(message = "Email không được để trống!")
    @UniqueEmail(message = "Email đã tồn tại!")
    private String email;
    @NotBlank(message = "Số điện thoại không được để trống!")
    @UniquePhoneNumber(message = "Số điện thoại đã tồn tại!")
    @Pattern(regexp = "^0[0-9]{9}$", message = "Số điện thoại không hợp lệ!")
    private String phoneNumber;
}
