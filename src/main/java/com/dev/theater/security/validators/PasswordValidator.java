package com.dev.theater.security.validators;

import com.dev.theater.model.dto.UserRegistrationDto;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.BeanWrapperImpl;

public class PasswordValidator
        implements ConstraintValidator<ValidatePassword, UserRegistrationDto> {
    private String password;
    private String repeatPassword;

    @Override
    public void initialize(ValidatePassword constraintAnnotation) {
        password = constraintAnnotation.field();
        repeatPassword = constraintAnnotation.fieldMatch();

    }

    @Override
    public boolean isValid(UserRegistrationDto userRegistrationDto,
                           ConstraintValidatorContext constraintValidatorContext) {
        Object fieldValue = new BeanWrapperImpl(userRegistrationDto)
                .getPropertyValue(password);
        Object fieldMatchValue = new BeanWrapperImpl(userRegistrationDto)
                .getPropertyValue(repeatPassword);
        if (fieldValue != null) {
            return fieldValue.equals(fieldMatchValue);
        } else {
            return fieldMatchValue == null;
        }
    }
}
