package com.example.graphql.dto;

import com.example.common.model.User;

/**
 * Payload DTO for Update User GraphQL mutation
 */
public class UpdateUserPayload {
    private User user;
    private boolean success;
    private String message;

    public UpdateUserPayload(User user, boolean success, String message) {
        this.user = user;
        this.success = success;
        this.message = message;
    }

    public UpdateUserPayload(boolean success, String message) {
        this.success = success;
        this.message = message;
    }

    // Getters
    public User getUser() {
        return user;
    }

    public boolean isSuccess() {
        return success;
    }

    public String getMessage() {
        return message;
    }
}