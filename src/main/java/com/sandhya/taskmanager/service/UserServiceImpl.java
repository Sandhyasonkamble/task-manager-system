package com.sandhya.taskmanager.service;

import com.sandhya.taskmanager.entity.User;
import com.sandhya.taskmanager.repository.UserRepository;
import org.springframework.stereotype.Service;
import com.sandhya.taskmanager.dto.RegisterRequest;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User registerUser(RegisterRequest request) {

        User user = new User();

        user.setName(request.getName());
        user.setEmail(request.getEmail());
        user.setPassword(request.getPassword());

        if (userRepository.findByEmail(user.getEmail()).isPresent()) {
            throw new RuntimeException("Email already exists");
        }

        return userRepository.save(user);
    }
}
