package com.sandhya.taskmanager.service;

import com.sandhya.taskmanager.dto.RegisterResponse;
import com.sandhya.taskmanager.dto.RegisterRequest;
import com.sandhya.taskmanager.dto.RegisterResponse;
import com.sandhya.taskmanager.dto.LoginRequest;
import com.sandhya.taskmanager.dto.LoginResponse;

public interface UserService {

    public RegisterResponse registerUser(RegisterRequest request);
    LoginResponse loginUser(LoginRequest request);
}