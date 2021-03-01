package com.dev.football.security.validators;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class EmailValidate implements ConstraintValidator<ValidateEmail, String> {
    @Override
    public boolean isValid(String email, ConstraintValidatorContext constraintValidatorContext) {
        return email != null && email.matches("[@]+[.]")
                && (email.length() > 8) && (email.length() < 14);
    }
}
