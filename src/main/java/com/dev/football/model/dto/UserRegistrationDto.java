package com.dev.football.model.dto;

import com.dev.football.security.validators.ValidateEmail;
import com.dev.football.security.validators.ValidatePassword;

@ValidatePassword.List({
        @ValidatePassword(
                field = "password",
                fieldMatch = "repeatPassword",
                message = "Password does not the same"
        )
})
public class UserRegistrationDto {
    @ValidateEmail
    private String email;
    private String password;
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
