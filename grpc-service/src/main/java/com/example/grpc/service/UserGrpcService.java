package com.example.grpc.service;

import com.example.common.model.User;
import com.example.common.service.UserService;
import com.example.grpc.proto.*;
import io.grpc.Status;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

/**
 * gRPC service implementation for User operations.
 * This service provides gRPC endpoints for user management.
 */
@GrpcService
public class UserGrpcService extends UserServiceGrpc.UserServiceImplBase {

    private final UserService userService;
    private final DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE_TIME;

    @Autowired
    public UserGrpcService(UserService userService) {
        this.userService = userService;
    }

    @Override
    public void createUser(CreateUserRequest request, StreamObserver<CreateUserResponse> responseObserver) {
        try {
            User user = new User();
            user.setUsername(request.getUsername());
            user.setEmail(request.getEmail());
            user.setFirstName(request.getFirstName());
            user.setLastName(request.getLastName());
            if (!request.getPhoneNumber().isEmpty()) {
                user.setPhoneNumber(request.getPhoneNumber());
            }

            User createdUser = userService.createUser(user);
            
            CreateUserResponse response = CreateUserResponse.newBuilder()
                    .setUser(convertToProtoUser(createdUser))
                    .setSuccess(true)
                    .setMessage("User created successfully")
                    .build();
            
            responseObserver.onNext(response);
            responseObserver.onCompleted();
            
        } catch (IllegalArgumentException e) {
            CreateUserResponse response = CreateUserResponse.newBuilder()
                    .setSuccess(false)
                    .setMessage("Failed to create user: " + e.getMessage())
                    .build();
            
            responseObserver.onNext(response);
            responseObserver.onCompleted();
            
        } catch (Exception e) {
            responseObserver.onError(Status.INTERNAL
                    .withDescription("Internal server error: " + e.getMessage())
                    .asRuntimeException());
        }
    }

    @Override
    public void getUser(GetUserRequest request, StreamObserver<GetUserResponse> responseObserver) {
        try {
            Optional<User> userOpt = userService.getUserById(request.getId());
            
            GetUserResponse response;
            if (userOpt.isPresent()) {
                response = GetUserResponse.newBuilder()
                        .setUser(convertToProtoUser(userOpt.get()))
                        .setFound(true)
                        .setMessage("User found")
                        .build();
            } else {
                response = GetUserResponse.newBuilder()
                        .setFound(false)
                        .setMessage("User not found")
                        .build();
            }
            
            responseObserver.onNext(response);
            responseObserver.onCompleted();
            
        } catch (Exception e) {
            responseObserver.onError(Status.INTERNAL
                    .withDescription("Internal server error: " + e.getMessage())
                    .asRuntimeException());
        }
    }

    @Override
    public void getUserByUsername(GetUserByUsernameRequest request, StreamObserver<GetUserResponse> responseObserver) {
        try {
            Optional<User> userOpt = userService.getUserByUsername(request.getUsername());
            
            GetUserResponse response;
            if (userOpt.isPresent()) {
                response = GetUserResponse.newBuilder()
                        .setUser(convertToProtoUser(userOpt.get()))
                        .setFound(true)
                        .setMessage("User found")
                        .build();
            } else {
                response = GetUserResponse.newBuilder()
                        .setFound(false)
                        .setMessage("User not found")
                        .build();
            }
            
            responseObserver.onNext(response);
            responseObserver.onCompleted();
            
        } catch (Exception e) {
            responseObserver.onError(Status.INTERNAL
                    .withDescription("Internal server error: " + e.getMessage())
                    .asRuntimeException());
        }
    }

    @Override
    public void getAllUsers(GetAllUsersRequest request, StreamObserver<GetAllUsersResponse> responseObserver) {
        try {
            List<User> users = request.getActiveOnly() ? 
                    userService.getActiveUsers() : 
                    userService.getAllUsers();
            
            GetAllUsersResponse.Builder responseBuilder = GetAllUsersResponse.newBuilder()
                    .setCount(users.size());
            
            for (User user : users) {
                responseBuilder.addUsers(convertToProtoUser(user));
            }
            
            responseObserver.onNext(responseBuilder.build());
            responseObserver.onCompleted();
            
        } catch (Exception e) {
            responseObserver.onError(Status.INTERNAL
                    .withDescription("Internal server error: " + e.getMessage())
                    .asRuntimeException());
        }
    }

    @Override
    public void searchUsers(SearchUsersRequest request, StreamObserver<SearchUsersResponse> responseObserver) {
        try {
            List<User> users = userService.searchUsersByName(request.getSearchTerm());
            
            SearchUsersResponse.Builder responseBuilder = SearchUsersResponse.newBuilder()
                    .setCount(users.size());
            
            for (User user : users) {
                responseBuilder.addUsers(convertToProtoUser(user));
            }
            
            responseObserver.onNext(responseBuilder.build());
            responseObserver.onCompleted();
            
        } catch (Exception e) {
            responseObserver.onError(Status.INTERNAL
                    .withDescription("Internal server error: " + e.getMessage())
                    .asRuntimeException());
        }
    }

    @Override
    public void updateUser(UpdateUserRequest request, StreamObserver<UpdateUserResponse> responseObserver) {
        try {
            User updateUser = new User();
            if (!request.getEmail().isEmpty()) {
                updateUser.setEmail(request.getEmail());
            }
            if (!request.getFirstName().isEmpty()) {
                updateUser.setFirstName(request.getFirstName());
            }
            if (!request.getLastName().isEmpty()) {
                updateUser.setLastName(request.getLastName());
            }
            if (!request.getPhoneNumber().isEmpty()) {
                updateUser.setPhoneNumber(request.getPhoneNumber());
            }
            updateUser.setActive(request.getActive());
            
            User updatedUser = userService.updateUser(request.getId(), updateUser);
            
            UpdateUserResponse response = UpdateUserResponse.newBuilder()
                    .setUser(convertToProtoUser(updatedUser))
                    .setSuccess(true)
                    .setMessage("User updated successfully")
                    .build();
            
            responseObserver.onNext(response);
            responseObserver.onCompleted();
            
        } catch (IllegalArgumentException e) {
            UpdateUserResponse response = UpdateUserResponse.newBuilder()
                    .setSuccess(false)
                    .setMessage("Failed to update user: " + e.getMessage())
                    .build();
            
            responseObserver.onNext(response);
            responseObserver.onCompleted();
            
        } catch (Exception e) {
            responseObserver.onError(Status.INTERNAL
                    .withDescription("Internal server error: " + e.getMessage())
                    .asRuntimeException());
        }
    }

    @Override
    public void deleteUser(DeleteUserRequest request, StreamObserver<DeleteUserResponse> responseObserver) {
        try {
            userService.deleteUser(request.getId());
            
            DeleteUserResponse response = DeleteUserResponse.newBuilder()
                    .setSuccess(true)
                    .setMessage("User deleted successfully")
                    .build();
            
            responseObserver.onNext(response);
            responseObserver.onCompleted();
            
        } catch (IllegalArgumentException e) {
            DeleteUserResponse response = DeleteUserResponse.newBuilder()
                    .setSuccess(false)
                    .setMessage("Failed to delete user: " + e.getMessage())
                    .build();
            
            responseObserver.onNext(response);
            responseObserver.onCompleted();
            
        } catch (Exception e) {
            responseObserver.onError(Status.INTERNAL
                    .withDescription("Internal server error: " + e.getMessage())
                    .asRuntimeException());
        }
    }

    @Override
    public void deactivateUser(DeactivateUserRequest request, StreamObserver<DeactivateUserResponse> responseObserver) {
        try {
            User deactivatedUser = userService.deactivateUser(request.getId());
            
            DeactivateUserResponse response = DeactivateUserResponse.newBuilder()
                    .setUser(convertToProtoUser(deactivatedUser))
                    .setSuccess(true)
                    .setMessage("User deactivated successfully")
                    .build();
            
            responseObserver.onNext(response);
            responseObserver.onCompleted();
            
        } catch (IllegalArgumentException e) {
            DeactivateUserResponse response = DeactivateUserResponse.newBuilder()
                    .setSuccess(false)
                    .setMessage("Failed to deactivate user: " + e.getMessage())
                    .build();
            
            responseObserver.onNext(response);
            responseObserver.onCompleted();
            
        } catch (Exception e) {
            responseObserver.onError(Status.INTERNAL
                    .withDescription("Internal server error: " + e.getMessage())
                    .asRuntimeException());
        }
    }

    /**
     * Convert domain User to proto User
     */
    private com.example.grpc.proto.User convertToProtoUser(User user) {
        com.example.grpc.proto.User.Builder builder = com.example.grpc.proto.User.newBuilder()
                .setId(user.getId())
                .setUsername(user.getUsername())
                .setEmail(user.getEmail())
                .setFirstName(user.getFirstName())
                .setLastName(user.getLastName())
                .setActive(user.getActive())
                .setCreatedAt(user.getCreatedAt().format(formatter));
        
        if (user.getPhoneNumber() != null) {
            builder.setPhoneNumber(user.getPhoneNumber());
        }
        if (user.getUpdatedAt() != null) {
            builder.setUpdatedAt(user.getUpdatedAt().format(formatter));
        }
        
        return builder.build();
    }
}