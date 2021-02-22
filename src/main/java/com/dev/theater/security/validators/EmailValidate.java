package com.dev.theater.security.validators;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class EmailValidate implements ConstraintValidator<ValidateEmail, String> {
    @Override
    public void initialize(ValidateEmail constraintAnnotation) {

    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        return s != null && s.matches("[@]+[.]")
                && (s.length() > 8) && (s.length() < 14);
    }
}
