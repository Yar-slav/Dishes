package com.yfedyna.dishes.user.controller;

import com.yfedyna.dishes.user.dto.LoginResponse;
import com.yfedyna.dishes.user.dto.UserLoginRequest;
import com.yfedyna.dishes.user.dto.UserRegistrationRequest;
import com.yfedyna.dishes.user.service.AuthService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
public class AuthController {

    private final AuthService authService;

    @PostMapping("/registration")
    @ResponseStatus(HttpStatus.CREATED)
    public void registration(
            @Valid @RequestBody UserRegistrationRequest requestDto) {
        authService.register(requestDto);
    }

    @GetMapping("/login")
    public LoginResponse login(
            @Valid @RequestBody UserLoginRequest request) {
        return authService.login(request);
    }
}
