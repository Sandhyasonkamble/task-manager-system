package com.sandhya.taskmanager.service;

import com.sandhya.taskmanager.entity.User;
import com.sandhya.taskmanager.dto.RegisterRequest;

public interface UserService {

    User registerUser(RegisterRequest request);

}