package com.example.app.controller;

import com.example.common.model.User;
import com.example.grpc.client.UserGrpcClient;
import com.example.grpc.proto.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * REST controller that demonstrates gRPC client usage.
 * This controller shows how to call gRPC services from REST endpoints.
 */
@RestController
@RequestMapping("/api/grpc/users")
@CrossOrigin(origins = "*")
public class GrpcDemoController {

    private final UserGrpcClient userGrpcClient;

    @Autowired
    public GrpcDemoController(UserGrpcClient userGrpcClient) {
        this.userGrpcClient = userGrpcClient;
    }

    /**
     * Create user via gRPC
     */
    @PostMapping
    public ResponseEntity<Map<String, Object>> createUser(@RequestBody Map<String, String> request) {
        try {
            CreateUserResponse response = userGrpcClient.createUser(
                    request.get("username"),
                    request.get("email"),
                    request.get("firstName"),
                    request.get("lastName"),
                    request.get("phoneNumber")
            );
            
            Map<String, Object> result = new HashMap<>();
            result.put("success", response.getSuccess());
            result.put("message", response.getMessage());
            if (response.hasUser()) {
                result.put("user", convertProtoUserToMap(response.getUser()));
            }
            
            return ResponseEntity.ok(result);
        } catch (Exception e) {
            Map<String, Object> error = new HashMap<>();
            error.put("success", false);
            error.put("message", "gRPC call failed: " + e.getMessage());
            return ResponseEntity.badRequest().body(error);
        }
    }

    /**
     * Get user by ID via gRPC
     */
    @GetMapping("/{id}")
    public ResponseEntity<Map<String, Object>> getUserById(@PathVariable Long id) {
        try {
            GetUserResponse response = userGrpcClient.getUserById(id);
            
            Map<String, Object> result = new HashMap<>();
            result.put("found", response.getFound());
            result.put("message", response.getMessage());
            if (response.hasUser()) {
                result.put("user", convertProtoUserToMap(response.getUser()));
            }
            
            return ResponseEntity.ok(result);
        } catch (Exception e) {
            Map<String, Object> error = new HashMap<>();
            error.put("found", false);
            error.put("message", "gRPC call failed: " + e.getMessage());
            return ResponseEntity.badRequest().body(error);
        }
    }

    /**
     * Get user by username via gRPC
     */
    @GetMapping("/username/{username}")
    public ResponseEntity<Map<String, Object>> getUserByUsername(@PathVariable String username) {
        try {
            GetUserResponse response = userGrpcClient.getUserByUsername(username);
            
            Map<String, Object> result = new HashMap<>();
            result.put("found", response.getFound());
            result.put("message", response.getMessage());
            if (response.hasUser()) {
                result.put("user", convertProtoUserToMap(response.getUser()));
            }
            
            return ResponseEntity.ok(result);
        } catch (Exception e) {
            Map<String, Object> error = new HashMap<>();
            error.put("found", false);
            error.put("message", "gRPC call failed: " + e.getMessage());
            return ResponseEntity.badRequest().body(error);
        }
    }

    /**
     * Get all users via gRPC
     */
    @GetMapping
    public ResponseEntity<Map<String, Object>> getAllUsers(@RequestParam(defaultValue = "false") boolean activeOnly) {
        try {
            GetAllUsersResponse response = userGrpcClient.getAllUsers(activeOnly);
            
            Map<String, Object> result = new HashMap<>();
            result.put("count", response.getCount());
            result.put("users", response.getUsersList().stream()
                    .map(this::convertProtoUserToMap)
                    .toArray());
            
            return ResponseEntity.ok(result);
        } catch (Exception e) {
            Map<String, Object> error = new HashMap<>();
            error.put("count", 0);
            error.put("message", "gRPC call failed: " + e.getMessage());
            return ResponseEntity.badRequest().body(error);
        }
    }

    /**
     * Search users via gRPC
     */
    @GetMapping("/search")
    public ResponseEntity<Map<String, Object>> searchUsers(@RequestParam String searchTerm) {
        try {
            SearchUsersResponse response = userGrpcClient.searchUsers(searchTerm);
            
            Map<String, Object> result = new HashMap<>();
            result.put("count", response.getCount());
            result.put("users", response.getUsersList().stream()
                    .map(this::convertProtoUserToMap)
                    .toArray());
            
            return ResponseEntity.ok(result);
        } catch (Exception e) {
            Map<String, Object> error = new HashMap<>();
            error.put("count", 0);
            error.put("message", "gRPC call failed: " + e.getMessage());
            return ResponseEntity.badRequest().body(error);
        }
    }

    /**
     * Convert proto User to Map for JSON response
     */
    private Map<String, Object> convertProtoUserToMap(com.example.grpc.proto.User protoUser) {
        Map<String, Object> userMap = new HashMap<>();
        userMap.put("id", protoUser.getId());
        userMap.put("username", protoUser.getUsername());
        userMap.put("email", protoUser.getEmail());
        userMap.put("firstName", protoUser.getFirstName());
        userMap.put("lastName", protoUser.getLastName());
        userMap.put("phoneNumber", protoUser.getPhoneNumber());
        userMap.put("createdAt", protoUser.getCreatedAt());
        userMap.put("updatedAt", protoUser.getUpdatedAt());
        userMap.put("active", protoUser.getActive());
        return userMap;
    }
}