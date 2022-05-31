package com.example.securityproject.controller;


import com.example.securityproject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class UserController {
    private final UserService userService;

    @Autowired

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/api/user/{id}")
    @PreAuthorize("hasAuthority('Admin')")
    public ResponseEntity<?> getUserbyId(@PathVariable String id) {
        return new ResponseEntity<Object>(userService.findUserInfoByUserId(id), HttpStatus.OK);
    }

    @GetMapping("/api/user/{name}")
    @PreAuthorize("hasAuthority('Admin')")
    public ResponseEntity<?> getUserbyName(@PathVariable String name) {
        return new ResponseEntity<Object>(userService.findUserInfoByUserName(name), HttpStatus.OK);
    }
}
