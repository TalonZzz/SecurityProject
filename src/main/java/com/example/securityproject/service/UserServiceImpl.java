package com.example.securityproject.service;

import com.example.securityproject.domain.User;
import com.example.securityproject.repository.UserRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;

    private final Logger logger = LogManager.getLogger(this.getClass());

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User findUserInfoByUserId(String userId) {
        return userRepository.findUserByUserId(userId);
    }

    @Override
    public User findUserInfoByUserName(String name) {
        return userRepository.findUserByUserName(name);
    }

}
