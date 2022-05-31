package com.example.securityproject.service;

import com.example.securityproject.domain.User;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    User findUserInfoByUserId(String userId);

    User findUserInfoByUserName(String name);

}
