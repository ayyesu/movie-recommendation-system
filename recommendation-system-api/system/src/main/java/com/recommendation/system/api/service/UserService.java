package com.recommendation.system.api.service;

import com.recommendation.system.api.models.UserEntity;
import com.recommendation.system.api.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public UserEntity getUserById(Integer userId) {
        return userRepository.findById(userId).orElse(null);
    }

    // You may also define other methods related to user management here
}

