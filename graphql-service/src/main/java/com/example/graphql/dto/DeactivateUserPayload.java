package com.example.graphql.dto;

import com.example.common.model.User;

/**
 * Payload DTO for Deactivate User GraphQL mutation
 */
public class DeactivateUserPayload {
    private User user;
    private boolean success;
    private String message;

    public DeactivateUserPayload(User user, boolean success, String message) {
        this.user = user;
        this.success = success;
        this.message = message;
    }

    public DeactivateUserPayload(boolean success, String message) {
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