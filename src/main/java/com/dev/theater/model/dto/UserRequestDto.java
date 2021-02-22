package com.dev.theater.model.dto;

import com.dev.theater.security.validators.ValidateEmail;
import com.sun.istack.NotNull;
import jakarta.validation.constraints.Min;

public class UserRequestDto {
    @ValidateEmail
    private String email;
    @NotNull
    @Min(6)
    private String password;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
