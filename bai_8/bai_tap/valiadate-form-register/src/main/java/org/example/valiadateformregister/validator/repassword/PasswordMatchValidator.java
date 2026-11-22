package org.example.valiadateformregister.validator.repassword;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.example.valiadateformregister.dto.UserDto;
import org.springframework.stereotype.Component;

@Component
public class PasswordMatchValidator implements ConstraintValidator<PasswordMatch, UserDto> {
    @Override
    public boolean isValid(UserDto userDto, ConstraintValidatorContext constraintValidatorContext) {
        if (userDto == null) {
            return true;
        }
        if (userDto.getPassword() == null || userDto.getConfirmPassword() == null) {
            return true;
        }
        if (!userDto.getPassword().equals(userDto.getConfirmPassword())) {
            constraintValidatorContext.buildConstraintViolationWithTemplate(constraintValidatorContext.getDefaultConstraintMessageTemplate()).addPropertyNode("confirmPassword").addConstraintViolation();
            return false;
        }
        return true;
    }
}
