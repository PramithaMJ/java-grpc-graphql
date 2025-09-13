package com.example.graphql.dto;

/**
 * Payload DTO for Delete User GraphQL mutation
 */
public class DeleteUserPayload {
    private boolean success;
    private String message;

    public DeleteUserPayload(boolean success, String message) {
        this.success = success;
        this.message = message;
    }

    // Getters
    public boolean isSuccess() {
        return success;
    }

    public String getMessage() {
        return message;
    }
}