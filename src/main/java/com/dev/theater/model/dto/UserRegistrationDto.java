package com.dev.theater.model.dto;

import jakarta.validation.constraints.NotNull;

public class UserRegistrationDto {
    @NotNull
    private String email;
    @NotNull
    private String password;
    @NotNull
    private String repeatPassword;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRepeatPassword() {
        return repeatPassword;
    }

    public void setRepeatPassword(String repeatPassword) {
        this.repeatPassword = repeatPassword;
    }
}
