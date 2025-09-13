package com.example.graphql.resolver;

import com.example.common.model.User;
import com.example.common.service.UserService;
import com.example.graphql.dto.*;
import graphql.kickstart.tools.GraphQLMutationResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * GraphQL Mutation Resolver for User operations.
 * This resolver handles all GraphQL mutations for users.
 */
@Component
public class UserMutationResolver implements GraphQLMutationResolver {

    private final UserService userService;

    @Autowired
    public UserMutationResolver(UserService userService) {
        this.userService = userService;
    }

    /**
     * Create a new user
     */
    public CreateUserPayload createUser(CreateUserInput input) {
        try {
            User user = new User();
            user.setUsername(input.getUsername());
            user.setEmail(input.getEmail());
            user.setFirstName(input.getFirstName());
            user.setLastName(input.getLastName());
            user.setPhoneNumber(input.getPhoneNumber());

            User createdUser = userService.createUser(user);
            return new CreateUserPayload(createdUser, true, "User created successfully");
        } catch (IllegalArgumentException e) {
            return new CreateUserPayload(false, "Failed to create user: " + e.getMessage());
        } catch (Exception e) {
            return new CreateUserPayload(false, "Internal error: " + e.getMessage());
        }
    }

    /**
     * Update an existing user
     */
    public UpdateUserPayload updateUser(String id, UpdateUserInput input) {
        try {
            Long userId = Long.parseLong(id);
            
            User updateUser = new User();
            updateUser.setEmail(input.getEmail());
            updateUser.setFirstName(input.getFirstName());
            updateUser.setLastName(input.getLastName());
            updateUser.setPhoneNumber(input.getPhoneNumber());
            updateUser.setActive(input.getActive());

            User updatedUser = userService.updateUser(userId, updateUser);
            return new UpdateUserPayload(updatedUser, true, "User updated successfully");
        } catch (NumberFormatException e) {
            return new UpdateUserPayload(false, "Invalid user ID format");
        } catch (IllegalArgumentException e) {
            return new UpdateUserPayload(false, "Failed to update user: " + e.getMessage());
        } catch (Exception e) {
            return new UpdateUserPayload(false, "Internal error: " + e.getMessage());
        }
    }

    /**
     * Delete a user
     */
    public DeleteUserPayload deleteUser(String id) {
        try {
            Long userId = Long.parseLong(id);
            userService.deleteUser(userId);
            return new DeleteUserPayload(true, "User deleted successfully");
        } catch (NumberFormatException e) {
            return new DeleteUserPayload(false, "Invalid user ID format");
        } catch (IllegalArgumentException e) {
            return new DeleteUserPayload(false, "Failed to delete user: " + e.getMessage());
        } catch (Exception e) {
            return new DeleteUserPayload(false, "Internal error: " + e.getMessage());
        }
    }

    /**
     * Deactivate a user
     */
    public DeactivateUserPayload deactivateUser(String id) {
        try {
            Long userId = Long.parseLong(id);
            User deactivatedUser = userService.deactivateUser(userId);
            return new DeactivateUserPayload(deactivatedUser, true, "User deactivated successfully");
        } catch (NumberFormatException e) {
            return new DeactivateUserPayload(false, "Invalid user ID format");
        } catch (IllegalArgumentException e) {
            return new DeactivateUserPayload(false, "Failed to deactivate user: " + e.getMessage());
        } catch (Exception e) {
            return new DeactivateUserPayload(false, "Internal error: " + e.getMessage());
        }
    }
}