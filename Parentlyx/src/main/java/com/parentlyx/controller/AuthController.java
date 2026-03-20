package com.parentlyx.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.parentlyx.model.User;
import com.parentlyx.service.UserService;

@RestController
@RequestMapping("/api/auth")   // ✅ Class-level mapping
@CrossOrigin(origins = "*")
public class AuthController {

    @Autowired
    private UserService service;

    @PostMapping("/register")
    public User register(@RequestBody User user) {
        return service.saveUser(user);
    }

    @PostMapping("/login")   // ✅ Method-level mapping
    public User login(@RequestBody User user) {
        return service.login(user.getUsername(), user.getPassword());
    }
}