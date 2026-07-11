package com.sandhya.taskmanager.service;

import com.sandhya.taskmanager.entity.User;
import com.sandhya.taskmanager.repository.UserRepository;
import org.springframework.stereotype.Service;
import com.sandhya.taskmanager.dto.RegisterRequest;

import org.springframework.security.crypto.password.PasswordEncoder;

import com.sandhya.taskmanager.dto.RegisterResponse;

import com.sandhya.taskmanager.dto.LoginRequest;
import com.sandhya.taskmanager.dto.LoginResponse;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository,
                           PasswordEncoder passwordEncoder) {

        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }
    @Override
    public RegisterResponse registerUser(RegisterRequest request) {

        User user = new User();

        user.setName(request.getName());
        user.setEmail(request.getEmail());
        user.setPassword(passwordEncoder.encode(request.getPassword()));

        if (userRepository.findByEmail(user.getEmail()).isPresent()) {
            throw new RuntimeException("Email already exists");
        }

        User savedUser = userRepository.save(user);

        RegisterResponse response = new RegisterResponse();

        response.setId(savedUser.getId());
        response.setName(savedUser.getName());
        response.setEmail(savedUser.getEmail());
        response.setMessage("User registered successfully");

        return response;
    }
    @Override
    public LoginResponse loginUser(LoginRequest request) {

        User user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new RuntimeException("Invalid email or password"));

        if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            throw new RuntimeException("Invalid email or password");
        }

        LoginResponse response = new LoginResponse();
        response.setId(user.getId());
        response.setName(user.getName());
        response.setEmail(user.getEmail());
        response.setMessage("Login successful");

        return response;
    }
}
