package com.example.common.service;

import com.example.common.model.User;
import com.example.common.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * Service class for User operations.
 * This service provides business logic for user management
 * and is shared between gRPC and GraphQL services.
 */
@Service
@Transactional
public class UserService {
    
    private final UserRepository userRepository;
    
    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    
    /**
     * Create a new user.
     * @param user the user to create
     * @return the created user
     * @throws IllegalArgumentException if username or email already exists
     */
    public User createUser(User user) {
        if (userRepository.existsByUsername(user.getUsername())) {
            throw new IllegalArgumentException("Username already exists: " + user.getUsername());
        }
        if (userRepository.existsByEmail(user.getEmail())) {
            throw new IllegalArgumentException("Email already exists: " + user.getEmail());
        }
        return userRepository.save(user);
    }
    
    /**
     * Get user by ID.
     * @param id the user ID
     * @return optional user if found
     */
    @Transactional(readOnly = true)
    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }
    
    /**
     * Get user by username.
     * @param username the username
     * @return optional user if found
     */
    @Transactional(readOnly = true)
    public Optional<User> getUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }
    
    /**
     * Get user by email.
     * @param email the email
     * @return optional user if found
     */
    @Transactional(readOnly = true)
    public Optional<User> getUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }
    
    /**
     * Get all users.
     * @return list of all users
     */
    @Transactional(readOnly = true)
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
    
    /**
     * Get all active users.
     * @return list of active users
     */
    @Transactional(readOnly = true)
    public List<User> getActiveUsers() {
        return userRepository.findByActiveTrue();
    }
    
    /**
     * Search users by name.
     * @param searchTerm the search term
     * @return list of matching users
     */
    @Transactional(readOnly = true)
    public List<User> searchUsersByName(String searchTerm) {
        return userRepository.findByNameContaining(searchTerm);
    }
    
    /**
     * Update an existing user.
     * @param id the user ID
     * @param updatedUser the updated user data
     * @return the updated user
     * @throws IllegalArgumentException if user not found
     */
    public User updateUser(Long id, User updatedUser) {
        Optional<User> existingUserOpt = userRepository.findById(id);
        if (existingUserOpt.isEmpty()) {
            throw new IllegalArgumentException("User not found with ID: " + id);
        }
        
        User existingUser = existingUserOpt.get();
        
        // Update fields if provided
        if (updatedUser.getFirstName() != null) {
            existingUser.setFirstName(updatedUser.getFirstName());
        }
        if (updatedUser.getLastName() != null) {
            existingUser.setLastName(updatedUser.getLastName());
        }
        if (updatedUser.getEmail() != null && !updatedUser.getEmail().equals(existingUser.getEmail())) {
            if (userRepository.existsByEmail(updatedUser.getEmail())) {
                throw new IllegalArgumentException("Email already exists: " + updatedUser.getEmail());
            }
            existingUser.setEmail(updatedUser.getEmail());
        }
        if (updatedUser.getPhoneNumber() != null) {
            existingUser.setPhoneNumber(updatedUser.getPhoneNumber());
        }
        if (updatedUser.getActive() != null) {
            existingUser.setActive(updatedUser.getActive());
        }
        
        return userRepository.save(existingUser);
    }
    
    /**
     * Delete a user by ID.
     * @param id the user ID
     * @throws IllegalArgumentException if user not found
     */
    public void deleteUser(Long id) {
        if (!userRepository.existsById(id)) {
            throw new IllegalArgumentException("User not found with ID: " + id);
        }
        userRepository.deleteById(id);
    }
    
    /**
     * Deactivate a user instead of deleting.
     * @param id the user ID
     * @return the deactivated user
     * @throws IllegalArgumentException if user not found
     */
    public User deactivateUser(Long id) {
        Optional<User> userOpt = userRepository.findById(id);
        if (userOpt.isEmpty()) {
            throw new IllegalArgumentException("User not found with ID: " + id);
        }
        
        User user = userOpt.get();
        user.setActive(false);
        return userRepository.save(user);
    }
}