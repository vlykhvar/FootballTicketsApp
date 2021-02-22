package com.dev.theater.controller;

import com.dev.theater.model.dto.UserRequestDto;
import com.dev.theater.security.AuthenticationService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/register")
public class AuthenticationController {
    private final AuthenticationService authenticationService;

    @Autowired
    public AuthenticationController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    @PostMapping("/register")
    public void registration(@Valid UserRequestDto requestDto) {
        authenticationService.register(requestDto.getEmail(), requestDto.getPassword());
    }
}
