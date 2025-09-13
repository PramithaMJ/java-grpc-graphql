package com.example.app.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * REST controller that provides information about available services.
 * This controller helps users understand what services are available.
 */
@RestController
@RequestMapping("/api/info")
@CrossOrigin(origins = "*")
public class InfoController {

    /**
     * Get information about available services
     */
    @GetMapping
    public ResponseEntity<Map<String, Object>> getServiceInfo() {
        Map<String, Object> info = new HashMap<>();
        info.put("application", "Java gRPC and GraphQL Demo");
        info.put("version", "1.0.0");
        info.put("description", "Comprehensive demonstration of Java with gRPC and GraphQL integration");
        
        Map<String, Object> services = new HashMap<>();
        
        // gRPC service info
        Map<String, Object> grpcInfo = new HashMap<>();
        grpcInfo.put("description", "gRPC service for user management");
        grpcInfo.put("port", 9090);
        grpcInfo.put("endpoints", new String[]{
                "CreateUser", "GetUser", "GetUserByUsername", "GetAllUsers",
                "SearchUsers", "UpdateUser", "DeleteUser", "DeactivateUser"
        });
        services.put("grpc", grpcInfo);
        
        // GraphQL service info
        Map<String, Object> graphqlInfo = new HashMap<>();
        graphqlInfo.put("description", "GraphQL service for user management");
        graphqlInfo.put("endpoint", "/graphql");
        graphqlInfo.put("playground", "/graphiql");
        graphqlInfo.put("queries", new String[]{"user", "userByUsername", "allUsers", "searchUsers"});
        graphqlInfo.put("mutations", new String[]{"createUser", "updateUser", "deleteUser", "deactivateUser"});
        services.put("graphql", graphqlInfo);
        
        // REST API info
        Map<String, Object> restInfo = new HashMap<>();
        restInfo.put("description", "REST endpoints demonstrating gRPC client usage");
        restInfo.put("base_path", "/api/grpc/users");
        restInfo.put("endpoints", new String[]{
                "POST /api/grpc/users - Create user via gRPC",
                "GET /api/grpc/users/{id} - Get user by ID via gRPC",
                "GET /api/grpc/users/username/{username} - Get user by username via gRPC",
                "GET /api/grpc/users - Get all users via gRPC",
                "GET /api/grpc/users/search?searchTerm={term} - Search users via gRPC"
        });
        services.put("rest", restInfo);
        
        info.put("services", services);
        
        Map<String, Object> sampleData = new HashMap<>();
        sampleData.put("createUser", Map.of(
                "username", "john_doe",
                "email", "john.doe@example.com",
                "firstName", "John",
                "lastName", "Doe",
                "phoneNumber", "+1234567890"
        ));
        info.put("sampleData", sampleData);
        
        return ResponseEntity.ok(info);
    }

    /**
     * Health check endpoint
     */
    @GetMapping("/health")
    public ResponseEntity<Map<String, String>> healthCheck() {
        Map<String, String> health = new HashMap<>();
        health.put("status", "UP");
        health.put("timestamp", java.time.Instant.now().toString());
        return ResponseEntity.ok(health);
    }
}