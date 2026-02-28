package com.parentlyx.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.parentlyx.model.User;
import com.parentlyx.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    // Save user (Admin/Teacher/Parent)
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    // Get all users
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    // Get users by role
    public List<User> getUsersByRole(String role) {
        return userRepository.findByRole(role);
    }

    // Count by role
    public long countByRole(String role) {
        return userRepository.countByRole(role);
    }

    // Find by username (login purpose)
    public Optional<User> findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    // Delete user
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
