package com.parentlyx.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.parentlyx.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    // Find user by username (for login)
    Optional<User> findByUsername(String username);

    // Get users by role
    List<User> findByRole(String role);

    // Count users by role
    long countByRole(String role);
}
