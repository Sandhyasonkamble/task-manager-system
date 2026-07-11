package com.sandhya.taskmanager.controller;

import com.sandhya.taskmanager.service.UserService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.sandhya.taskmanager.entity.User;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.sandhya.taskmanager.dto.RegisterRequest;
import jakarta.validation.Valid;
import com.sandhya.taskmanager.dto.RegisterResponse;
import com.sandhya.taskmanager.dto.LoginRequest;
import com.sandhya.taskmanager.dto.LoginResponse;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final UserService userService;

    public AuthController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public RegisterResponse registerUser(@Valid @RequestBody RegisterRequest request) {
        return userService.registerUser(request);
    }

    @PostMapping("/login")
    public LoginResponse loginUser(@Valid @RequestBody LoginRequest request) {
        return userService.loginUser(request);
    }
}
