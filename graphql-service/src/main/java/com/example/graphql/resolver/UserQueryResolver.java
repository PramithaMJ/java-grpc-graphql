package com.example.graphql.resolver;

import com.example.common.model.User;
import com.example.common.service.UserService;
import graphql.kickstart.tools.GraphQLQueryResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

/**
 * GraphQL Query Resolver for User operations.
 * This resolver handles all GraphQL queries for users.
 */
@Component
public class UserQueryResolver implements GraphQLQueryResolver {

    private final UserService userService;

    @Autowired
    public UserQueryResolver(UserService userService) {
        this.userService = userService;
    }

    /**
     * Get user by ID
     */
    public User user(String id) {
        try {
            Long userId = Long.parseLong(id);
            Optional<User> userOpt = userService.getUserById(userId);
            return userOpt.orElse(null);
        } catch (NumberFormatException e) {
            return null;
        }
    }

    /**
     * Get user by username
     */
    public User userByUsername(String username) {
        Optional<User> userOpt = userService.getUserByUsername(username);
        return userOpt.orElse(null);
    }

    /**
     * Get all users
     */
    public List<User> allUsers(Boolean activeOnly) {
        if (activeOnly != null && activeOnly) {
            return userService.getActiveUsers();
        }
        return userService.getAllUsers();
    }

    /**
     * Search users by name
     */
    public List<User> searchUsers(String searchTerm) {
        return userService.searchUsersByName(searchTerm);
    }
}