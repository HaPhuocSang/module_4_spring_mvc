package org.example.valiadateformregister.validator.phonenumber;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = UniquePhoneNumberValidator.class)
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface UniquePhoneNumber {
    String message() default "Số điện thoại đã tồn tại";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
