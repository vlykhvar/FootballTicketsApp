package com.dev.theater.model.dto;

import com.sun.istack.NotNull;
import jakarta.validation.constraints.Size;

public class UserRequestDto {
    @NotNull
    private String email;
    @NotNull
    @Size(min = 5)
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
