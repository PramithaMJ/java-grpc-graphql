package com.example.grpc.client;

import com.example.grpc.proto.*;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * gRPC client for User service.
 * This client demonstrates how to call gRPC services.
 */
@Component
public class UserGrpcClient {

    @GrpcClient("user-service")
    private UserServiceGrpc.UserServiceBlockingStub userServiceStub;

    /**
     * Create a new user via gRPC
     */
    public CreateUserResponse createUser(String username, String email, String firstName, String lastName, String phoneNumber) {
        CreateUserRequest.Builder requestBuilder = CreateUserRequest.newBuilder()
                .setUsername(username)
                .setEmail(email)
                .setFirstName(firstName)
                .setLastName(lastName);
        
        if (phoneNumber != null && !phoneNumber.isEmpty()) {
            requestBuilder.setPhoneNumber(phoneNumber);
        }
        
        return userServiceStub
                .withDeadlineAfter(5, TimeUnit.SECONDS)
                .createUser(requestBuilder.build());
    }

    /**
     * Get user by ID via gRPC
     */
    public GetUserResponse getUserById(Long userId) {
        GetUserRequest request = GetUserRequest.newBuilder()
                .setId(userId)
                .build();
        
        return userServiceStub
                .withDeadlineAfter(5, TimeUnit.SECONDS)
                .getUser(request);
    }

    /**
     * Get user by username via gRPC
     */
    public GetUserResponse getUserByUsername(String username) {
        GetUserByUsernameRequest request = GetUserByUsernameRequest.newBuilder()
                .setUsername(username)
                .build();
        
        return userServiceStub
                .withDeadlineAfter(5, TimeUnit.SECONDS)
                .getUserByUsername(request);
    }

    /**
     * Get all users via gRPC
     */
    public GetAllUsersResponse getAllUsers(boolean activeOnly) {
        GetAllUsersRequest request = GetAllUsersRequest.newBuilder()
                .setActiveOnly(activeOnly)
                .build();
        
        return userServiceStub
                .withDeadlineAfter(10, TimeUnit.SECONDS)
                .getAllUsers(request);
    }

    /**
     * Search users by name via gRPC
     */
    public SearchUsersResponse searchUsers(String searchTerm) {
        SearchUsersRequest request = SearchUsersRequest.newBuilder()
                .setSearchTerm(searchTerm)
                .build();
        
        return userServiceStub
                .withDeadlineAfter(10, TimeUnit.SECONDS)
                .searchUsers(request);
    }

    /**
     * Update user via gRPC
     */
    public UpdateUserResponse updateUser(Long userId, String email, String firstName, String lastName, String phoneNumber, Boolean active) {
        UpdateUserRequest.Builder requestBuilder = UpdateUserRequest.newBuilder()
                .setId(userId);
        
        if (email != null && !email.isEmpty()) {
            requestBuilder.setEmail(email);
        }
        if (firstName != null && !firstName.isEmpty()) {
            requestBuilder.setFirstName(firstName);
        }
        if (lastName != null && !lastName.isEmpty()) {
            requestBuilder.setLastName(lastName);
        }
        if (phoneNumber != null && !phoneNumber.isEmpty()) {
            requestBuilder.setPhoneNumber(phoneNumber);
        }
        if (active != null) {
            requestBuilder.setActive(active);
        }
        
        return userServiceStub
                .withDeadlineAfter(5, TimeUnit.SECONDS)
                .updateUser(requestBuilder.build());
    }

    /**
     * Delete user via gRPC
     */
    public DeleteUserResponse deleteUser(Long userId) {
        DeleteUserRequest request = DeleteUserRequest.newBuilder()
                .setId(userId)
                .build();
        
        return userServiceStub
                .withDeadlineAfter(5, TimeUnit.SECONDS)
                .deleteUser(request);
    }

    /**
     * Deactivate user via gRPC
     */
    public DeactivateUserResponse deactivateUser(Long userId) {
        DeactivateUserRequest request = DeactivateUserRequest.newBuilder()
                .setId(userId)
                .build();
        
        return userServiceStub
                .withDeadlineAfter(5, TimeUnit.SECONDS)
                .deactivateUser(request);
    }
}