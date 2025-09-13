package com.example.grpc.proto;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 * <pre>
 * User service definition
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.51.0)",
    comments = "Source: user_service.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class UserServiceGrpc {

  private UserServiceGrpc() {}

  public static final String SERVICE_NAME = "com.example.grpc.UserService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.example.grpc.proto.CreateUserRequest,
      com.example.grpc.proto.CreateUserResponse> getCreateUserMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateUser",
      requestType = com.example.grpc.proto.CreateUserRequest.class,
      responseType = com.example.grpc.proto.CreateUserResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.example.grpc.proto.CreateUserRequest,
      com.example.grpc.proto.CreateUserResponse> getCreateUserMethod() {
    io.grpc.MethodDescriptor<com.example.grpc.proto.CreateUserRequest, com.example.grpc.proto.CreateUserResponse> getCreateUserMethod;
    if ((getCreateUserMethod = UserServiceGrpc.getCreateUserMethod) == null) {
      synchronized (UserServiceGrpc.class) {
        if ((getCreateUserMethod = UserServiceGrpc.getCreateUserMethod) == null) {
          UserServiceGrpc.getCreateUserMethod = getCreateUserMethod =
              io.grpc.MethodDescriptor.<com.example.grpc.proto.CreateUserRequest, com.example.grpc.proto.CreateUserResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateUser"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.grpc.proto.CreateUserRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.grpc.proto.CreateUserResponse.getDefaultInstance()))
              .setSchemaDescriptor(new UserServiceMethodDescriptorSupplier("CreateUser"))
              .build();
        }
      }
    }
    return getCreateUserMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.example.grpc.proto.GetUserRequest,
      com.example.grpc.proto.GetUserResponse> getGetUserMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetUser",
      requestType = com.example.grpc.proto.GetUserRequest.class,
      responseType = com.example.grpc.proto.GetUserResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.example.grpc.proto.GetUserRequest,
      com.example.grpc.proto.GetUserResponse> getGetUserMethod() {
    io.grpc.MethodDescriptor<com.example.grpc.proto.GetUserRequest, com.example.grpc.proto.GetUserResponse> getGetUserMethod;
    if ((getGetUserMethod = UserServiceGrpc.getGetUserMethod) == null) {
      synchronized (UserServiceGrpc.class) {
        if ((getGetUserMethod = UserServiceGrpc.getGetUserMethod) == null) {
          UserServiceGrpc.getGetUserMethod = getGetUserMethod =
              io.grpc.MethodDescriptor.<com.example.grpc.proto.GetUserRequest, com.example.grpc.proto.GetUserResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetUser"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.grpc.proto.GetUserRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.grpc.proto.GetUserResponse.getDefaultInstance()))
              .setSchemaDescriptor(new UserServiceMethodDescriptorSupplier("GetUser"))
              .build();
        }
      }
    }
    return getGetUserMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.example.grpc.proto.GetUserByUsernameRequest,
      com.example.grpc.proto.GetUserResponse> getGetUserByUsernameMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetUserByUsername",
      requestType = com.example.grpc.proto.GetUserByUsernameRequest.class,
      responseType = com.example.grpc.proto.GetUserResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.example.grpc.proto.GetUserByUsernameRequest,
      com.example.grpc.proto.GetUserResponse> getGetUserByUsernameMethod() {
    io.grpc.MethodDescriptor<com.example.grpc.proto.GetUserByUsernameRequest, com.example.grpc.proto.GetUserResponse> getGetUserByUsernameMethod;
    if ((getGetUserByUsernameMethod = UserServiceGrpc.getGetUserByUsernameMethod) == null) {
      synchronized (UserServiceGrpc.class) {
        if ((getGetUserByUsernameMethod = UserServiceGrpc.getGetUserByUsernameMethod) == null) {
          UserServiceGrpc.getGetUserByUsernameMethod = getGetUserByUsernameMethod =
              io.grpc.MethodDescriptor.<com.example.grpc.proto.GetUserByUsernameRequest, com.example.grpc.proto.GetUserResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetUserByUsername"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.grpc.proto.GetUserByUsernameRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.grpc.proto.GetUserResponse.getDefaultInstance()))
              .setSchemaDescriptor(new UserServiceMethodDescriptorSupplier("GetUserByUsername"))
              .build();
        }
      }
    }
    return getGetUserByUsernameMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.example.grpc.proto.GetAllUsersRequest,
      com.example.grpc.proto.GetAllUsersResponse> getGetAllUsersMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetAllUsers",
      requestType = com.example.grpc.proto.GetAllUsersRequest.class,
      responseType = com.example.grpc.proto.GetAllUsersResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.example.grpc.proto.GetAllUsersRequest,
      com.example.grpc.proto.GetAllUsersResponse> getGetAllUsersMethod() {
    io.grpc.MethodDescriptor<com.example.grpc.proto.GetAllUsersRequest, com.example.grpc.proto.GetAllUsersResponse> getGetAllUsersMethod;
    if ((getGetAllUsersMethod = UserServiceGrpc.getGetAllUsersMethod) == null) {
      synchronized (UserServiceGrpc.class) {
        if ((getGetAllUsersMethod = UserServiceGrpc.getGetAllUsersMethod) == null) {
          UserServiceGrpc.getGetAllUsersMethod = getGetAllUsersMethod =
              io.grpc.MethodDescriptor.<com.example.grpc.proto.GetAllUsersRequest, com.example.grpc.proto.GetAllUsersResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetAllUsers"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.grpc.proto.GetAllUsersRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.grpc.proto.GetAllUsersResponse.getDefaultInstance()))
              .setSchemaDescriptor(new UserServiceMethodDescriptorSupplier("GetAllUsers"))
              .build();
        }
      }
    }
    return getGetAllUsersMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.example.grpc.proto.SearchUsersRequest,
      com.example.grpc.proto.SearchUsersResponse> getSearchUsersMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "SearchUsers",
      requestType = com.example.grpc.proto.SearchUsersRequest.class,
      responseType = com.example.grpc.proto.SearchUsersResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.example.grpc.proto.SearchUsersRequest,
      com.example.grpc.proto.SearchUsersResponse> getSearchUsersMethod() {
    io.grpc.MethodDescriptor<com.example.grpc.proto.SearchUsersRequest, com.example.grpc.proto.SearchUsersResponse> getSearchUsersMethod;
    if ((getSearchUsersMethod = UserServiceGrpc.getSearchUsersMethod) == null) {
      synchronized (UserServiceGrpc.class) {
        if ((getSearchUsersMethod = UserServiceGrpc.getSearchUsersMethod) == null) {
          UserServiceGrpc.getSearchUsersMethod = getSearchUsersMethod =
              io.grpc.MethodDescriptor.<com.example.grpc.proto.SearchUsersRequest, com.example.grpc.proto.SearchUsersResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "SearchUsers"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.grpc.proto.SearchUsersRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.grpc.proto.SearchUsersResponse.getDefaultInstance()))
              .setSchemaDescriptor(new UserServiceMethodDescriptorSupplier("SearchUsers"))
              .build();
        }
      }
    }
    return getSearchUsersMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.example.grpc.proto.UpdateUserRequest,
      com.example.grpc.proto.UpdateUserResponse> getUpdateUserMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateUser",
      requestType = com.example.grpc.proto.UpdateUserRequest.class,
      responseType = com.example.grpc.proto.UpdateUserResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.example.grpc.proto.UpdateUserRequest,
      com.example.grpc.proto.UpdateUserResponse> getUpdateUserMethod() {
    io.grpc.MethodDescriptor<com.example.grpc.proto.UpdateUserRequest, com.example.grpc.proto.UpdateUserResponse> getUpdateUserMethod;
    if ((getUpdateUserMethod = UserServiceGrpc.getUpdateUserMethod) == null) {
      synchronized (UserServiceGrpc.class) {
        if ((getUpdateUserMethod = UserServiceGrpc.getUpdateUserMethod) == null) {
          UserServiceGrpc.getUpdateUserMethod = getUpdateUserMethod =
              io.grpc.MethodDescriptor.<com.example.grpc.proto.UpdateUserRequest, com.example.grpc.proto.UpdateUserResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateUser"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.grpc.proto.UpdateUserRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.grpc.proto.UpdateUserResponse.getDefaultInstance()))
              .setSchemaDescriptor(new UserServiceMethodDescriptorSupplier("UpdateUser"))
              .build();
        }
      }
    }
    return getUpdateUserMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.example.grpc.proto.DeleteUserRequest,
      com.example.grpc.proto.DeleteUserResponse> getDeleteUserMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteUser",
      requestType = com.example.grpc.proto.DeleteUserRequest.class,
      responseType = com.example.grpc.proto.DeleteUserResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.example.grpc.proto.DeleteUserRequest,
      com.example.grpc.proto.DeleteUserResponse> getDeleteUserMethod() {
    io.grpc.MethodDescriptor<com.example.grpc.proto.DeleteUserRequest, com.example.grpc.proto.DeleteUserResponse> getDeleteUserMethod;
    if ((getDeleteUserMethod = UserServiceGrpc.getDeleteUserMethod) == null) {
      synchronized (UserServiceGrpc.class) {
        if ((getDeleteUserMethod = UserServiceGrpc.getDeleteUserMethod) == null) {
          UserServiceGrpc.getDeleteUserMethod = getDeleteUserMethod =
              io.grpc.MethodDescriptor.<com.example.grpc.proto.DeleteUserRequest, com.example.grpc.proto.DeleteUserResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteUser"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.grpc.proto.DeleteUserRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.grpc.proto.DeleteUserResponse.getDefaultInstance()))
              .setSchemaDescriptor(new UserServiceMethodDescriptorSupplier("DeleteUser"))
              .build();
        }
      }
    }
    return getDeleteUserMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.example.grpc.proto.DeactivateUserRequest,
      com.example.grpc.proto.DeactivateUserResponse> getDeactivateUserMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeactivateUser",
      requestType = com.example.grpc.proto.DeactivateUserRequest.class,
      responseType = com.example.grpc.proto.DeactivateUserResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.example.grpc.proto.DeactivateUserRequest,
      com.example.grpc.proto.DeactivateUserResponse> getDeactivateUserMethod() {
    io.grpc.MethodDescriptor<com.example.grpc.proto.DeactivateUserRequest, com.example.grpc.proto.DeactivateUserResponse> getDeactivateUserMethod;
    if ((getDeactivateUserMethod = UserServiceGrpc.getDeactivateUserMethod) == null) {
      synchronized (UserServiceGrpc.class) {
        if ((getDeactivateUserMethod = UserServiceGrpc.getDeactivateUserMethod) == null) {
          UserServiceGrpc.getDeactivateUserMethod = getDeactivateUserMethod =
              io.grpc.MethodDescriptor.<com.example.grpc.proto.DeactivateUserRequest, com.example.grpc.proto.DeactivateUserResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeactivateUser"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.grpc.proto.DeactivateUserRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.grpc.proto.DeactivateUserResponse.getDefaultInstance()))
              .setSchemaDescriptor(new UserServiceMethodDescriptorSupplier("DeactivateUser"))
              .build();
        }
      }
    }
    return getDeactivateUserMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static UserServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<UserServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<UserServiceStub>() {
        @java.lang.Override
        public UserServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new UserServiceStub(channel, callOptions);
        }
      };
    return UserServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static UserServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<UserServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<UserServiceBlockingStub>() {
        @java.lang.Override
        public UserServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new UserServiceBlockingStub(channel, callOptions);
        }
      };
    return UserServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static UserServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<UserServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<UserServiceFutureStub>() {
        @java.lang.Override
        public UserServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new UserServiceFutureStub(channel, callOptions);
        }
      };
    return UserServiceFutureStub.newStub(factory, channel);
  }

  /**
   * <pre>
   * User service definition
   * </pre>
   */
  public static abstract class UserServiceImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     * Create a new user
     * </pre>
     */
    public void createUser(com.example.grpc.proto.CreateUserRequest request,
        io.grpc.stub.StreamObserver<com.example.grpc.proto.CreateUserResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getCreateUserMethod(), responseObserver);
    }

    /**
     * <pre>
     * Get user by ID
     * </pre>
     */
    public void getUser(com.example.grpc.proto.GetUserRequest request,
        io.grpc.stub.StreamObserver<com.example.grpc.proto.GetUserResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetUserMethod(), responseObserver);
    }

    /**
     * <pre>
     * Get user by username
     * </pre>
     */
    public void getUserByUsername(com.example.grpc.proto.GetUserByUsernameRequest request,
        io.grpc.stub.StreamObserver<com.example.grpc.proto.GetUserResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetUserByUsernameMethod(), responseObserver);
    }

    /**
     * <pre>
     * Get all users
     * </pre>
     */
    public void getAllUsers(com.example.grpc.proto.GetAllUsersRequest request,
        io.grpc.stub.StreamObserver<com.example.grpc.proto.GetAllUsersResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetAllUsersMethod(), responseObserver);
    }

    /**
     * <pre>
     * Search users by name
     * </pre>
     */
    public void searchUsers(com.example.grpc.proto.SearchUsersRequest request,
        io.grpc.stub.StreamObserver<com.example.grpc.proto.SearchUsersResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getSearchUsersMethod(), responseObserver);
    }

    /**
     * <pre>
     * Update user
     * </pre>
     */
    public void updateUser(com.example.grpc.proto.UpdateUserRequest request,
        io.grpc.stub.StreamObserver<com.example.grpc.proto.UpdateUserResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getUpdateUserMethod(), responseObserver);
    }

    /**
     * <pre>
     * Delete user
     * </pre>
     */
    public void deleteUser(com.example.grpc.proto.DeleteUserRequest request,
        io.grpc.stub.StreamObserver<com.example.grpc.proto.DeleteUserResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getDeleteUserMethod(), responseObserver);
    }

    /**
     * <pre>
     * Deactivate user
     * </pre>
     */
    public void deactivateUser(com.example.grpc.proto.DeactivateUserRequest request,
        io.grpc.stub.StreamObserver<com.example.grpc.proto.DeactivateUserResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getDeactivateUserMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getCreateUserMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.example.grpc.proto.CreateUserRequest,
                com.example.grpc.proto.CreateUserResponse>(
                  this, METHODID_CREATE_USER)))
          .addMethod(
            getGetUserMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.example.grpc.proto.GetUserRequest,
                com.example.grpc.proto.GetUserResponse>(
                  this, METHODID_GET_USER)))
          .addMethod(
            getGetUserByUsernameMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.example.grpc.proto.GetUserByUsernameRequest,
                com.example.grpc.proto.GetUserResponse>(
                  this, METHODID_GET_USER_BY_USERNAME)))
          .addMethod(
            getGetAllUsersMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.example.grpc.proto.GetAllUsersRequest,
                com.example.grpc.proto.GetAllUsersResponse>(
                  this, METHODID_GET_ALL_USERS)))
          .addMethod(
            getSearchUsersMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.example.grpc.proto.SearchUsersRequest,
                com.example.grpc.proto.SearchUsersResponse>(
                  this, METHODID_SEARCH_USERS)))
          .addMethod(
            getUpdateUserMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.example.grpc.proto.UpdateUserRequest,
                com.example.grpc.proto.UpdateUserResponse>(
                  this, METHODID_UPDATE_USER)))
          .addMethod(
            getDeleteUserMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.example.grpc.proto.DeleteUserRequest,
                com.example.grpc.proto.DeleteUserResponse>(
                  this, METHODID_DELETE_USER)))
          .addMethod(
            getDeactivateUserMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.example.grpc.proto.DeactivateUserRequest,
                com.example.grpc.proto.DeactivateUserResponse>(
                  this, METHODID_DEACTIVATE_USER)))
          .build();
    }
  }

  /**
   * <pre>
   * User service definition
   * </pre>
   */
  public static final class UserServiceStub extends io.grpc.stub.AbstractAsyncStub<UserServiceStub> {
    private UserServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected UserServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new UserServiceStub(channel, callOptions);
    }

    /**
     * <pre>
     * Create a new user
     * </pre>
     */
    public void createUser(com.example.grpc.proto.CreateUserRequest request,
        io.grpc.stub.StreamObserver<com.example.grpc.proto.CreateUserResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateUserMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Get user by ID
     * </pre>
     */
    public void getUser(com.example.grpc.proto.GetUserRequest request,
        io.grpc.stub.StreamObserver<com.example.grpc.proto.GetUserResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetUserMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Get user by username
     * </pre>
     */
    public void getUserByUsername(com.example.grpc.proto.GetUserByUsernameRequest request,
        io.grpc.stub.StreamObserver<com.example.grpc.proto.GetUserResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetUserByUsernameMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Get all users
     * </pre>
     */
    public void getAllUsers(com.example.grpc.proto.GetAllUsersRequest request,
        io.grpc.stub.StreamObserver<com.example.grpc.proto.GetAllUsersResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetAllUsersMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Search users by name
     * </pre>
     */
    public void searchUsers(com.example.grpc.proto.SearchUsersRequest request,
        io.grpc.stub.StreamObserver<com.example.grpc.proto.SearchUsersResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getSearchUsersMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Update user
     * </pre>
     */
    public void updateUser(com.example.grpc.proto.UpdateUserRequest request,
        io.grpc.stub.StreamObserver<com.example.grpc.proto.UpdateUserResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateUserMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Delete user
     * </pre>
     */
    public void deleteUser(com.example.grpc.proto.DeleteUserRequest request,
        io.grpc.stub.StreamObserver<com.example.grpc.proto.DeleteUserResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteUserMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Deactivate user
     * </pre>
     */
    public void deactivateUser(com.example.grpc.proto.DeactivateUserRequest request,
        io.grpc.stub.StreamObserver<com.example.grpc.proto.DeactivateUserResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeactivateUserMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * <pre>
   * User service definition
   * </pre>
   */
  public static final class UserServiceBlockingStub extends io.grpc.stub.AbstractBlockingStub<UserServiceBlockingStub> {
    private UserServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected UserServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new UserServiceBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * Create a new user
     * </pre>
     */
    public com.example.grpc.proto.CreateUserResponse createUser(com.example.grpc.proto.CreateUserRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateUserMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Get user by ID
     * </pre>
     */
    public com.example.grpc.proto.GetUserResponse getUser(com.example.grpc.proto.GetUserRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetUserMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Get user by username
     * </pre>
     */
    public com.example.grpc.proto.GetUserResponse getUserByUsername(com.example.grpc.proto.GetUserByUsernameRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetUserByUsernameMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Get all users
     * </pre>
     */
    public com.example.grpc.proto.GetAllUsersResponse getAllUsers(com.example.grpc.proto.GetAllUsersRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetAllUsersMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Search users by name
     * </pre>
     */
    public com.example.grpc.proto.SearchUsersResponse searchUsers(com.example.grpc.proto.SearchUsersRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getSearchUsersMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Update user
     * </pre>
     */
    public com.example.grpc.proto.UpdateUserResponse updateUser(com.example.grpc.proto.UpdateUserRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateUserMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Delete user
     * </pre>
     */
    public com.example.grpc.proto.DeleteUserResponse deleteUser(com.example.grpc.proto.DeleteUserRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteUserMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Deactivate user
     * </pre>
     */
    public com.example.grpc.proto.DeactivateUserResponse deactivateUser(com.example.grpc.proto.DeactivateUserRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeactivateUserMethod(), getCallOptions(), request);
    }
  }

  /**
   * <pre>
   * User service definition
   * </pre>
   */
  public static final class UserServiceFutureStub extends io.grpc.stub.AbstractFutureStub<UserServiceFutureStub> {
    private UserServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected UserServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new UserServiceFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * Create a new user
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.example.grpc.proto.CreateUserResponse> createUser(
        com.example.grpc.proto.CreateUserRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateUserMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Get user by ID
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.example.grpc.proto.GetUserResponse> getUser(
        com.example.grpc.proto.GetUserRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetUserMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Get user by username
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.example.grpc.proto.GetUserResponse> getUserByUsername(
        com.example.grpc.proto.GetUserByUsernameRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetUserByUsernameMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Get all users
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.example.grpc.proto.GetAllUsersResponse> getAllUsers(
        com.example.grpc.proto.GetAllUsersRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetAllUsersMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Search users by name
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.example.grpc.proto.SearchUsersResponse> searchUsers(
        com.example.grpc.proto.SearchUsersRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getSearchUsersMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Update user
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.example.grpc.proto.UpdateUserResponse> updateUser(
        com.example.grpc.proto.UpdateUserRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateUserMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Delete user
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.example.grpc.proto.DeleteUserResponse> deleteUser(
        com.example.grpc.proto.DeleteUserRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteUserMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Deactivate user
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.example.grpc.proto.DeactivateUserResponse> deactivateUser(
        com.example.grpc.proto.DeactivateUserRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeactivateUserMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_CREATE_USER = 0;
  private static final int METHODID_GET_USER = 1;
  private static final int METHODID_GET_USER_BY_USERNAME = 2;
  private static final int METHODID_GET_ALL_USERS = 3;
  private static final int METHODID_SEARCH_USERS = 4;
  private static final int METHODID_UPDATE_USER = 5;
  private static final int METHODID_DELETE_USER = 6;
  private static final int METHODID_DEACTIVATE_USER = 7;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final UserServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(UserServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_CREATE_USER:
          serviceImpl.createUser((com.example.grpc.proto.CreateUserRequest) request,
              (io.grpc.stub.StreamObserver<com.example.grpc.proto.CreateUserResponse>) responseObserver);
          break;
        case METHODID_GET_USER:
          serviceImpl.getUser((com.example.grpc.proto.GetUserRequest) request,
              (io.grpc.stub.StreamObserver<com.example.grpc.proto.GetUserResponse>) responseObserver);
          break;
        case METHODID_GET_USER_BY_USERNAME:
          serviceImpl.getUserByUsername((com.example.grpc.proto.GetUserByUsernameRequest) request,
              (io.grpc.stub.StreamObserver<com.example.grpc.proto.GetUserResponse>) responseObserver);
          break;
        case METHODID_GET_ALL_USERS:
          serviceImpl.getAllUsers((com.example.grpc.proto.GetAllUsersRequest) request,
              (io.grpc.stub.StreamObserver<com.example.grpc.proto.GetAllUsersResponse>) responseObserver);
          break;
        case METHODID_SEARCH_USERS:
          serviceImpl.searchUsers((com.example.grpc.proto.SearchUsersRequest) request,
              (io.grpc.stub.StreamObserver<com.example.grpc.proto.SearchUsersResponse>) responseObserver);
          break;
        case METHODID_UPDATE_USER:
          serviceImpl.updateUser((com.example.grpc.proto.UpdateUserRequest) request,
              (io.grpc.stub.StreamObserver<com.example.grpc.proto.UpdateUserResponse>) responseObserver);
          break;
        case METHODID_DELETE_USER:
          serviceImpl.deleteUser((com.example.grpc.proto.DeleteUserRequest) request,
              (io.grpc.stub.StreamObserver<com.example.grpc.proto.DeleteUserResponse>) responseObserver);
          break;
        case METHODID_DEACTIVATE_USER:
          serviceImpl.deactivateUser((com.example.grpc.proto.DeactivateUserRequest) request,
              (io.grpc.stub.StreamObserver<com.example.grpc.proto.DeactivateUserResponse>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class UserServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    UserServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.example.grpc.proto.UserServiceProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("UserService");
    }
  }

  private static final class UserServiceFileDescriptorSupplier
      extends UserServiceBaseDescriptorSupplier {
    UserServiceFileDescriptorSupplier() {}
  }

  private static final class UserServiceMethodDescriptorSupplier
      extends UserServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    UserServiceMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (UserServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new UserServiceFileDescriptorSupplier())
              .addMethod(getCreateUserMethod())
              .addMethod(getGetUserMethod())
              .addMethod(getGetUserByUsernameMethod())
              .addMethod(getGetAllUsersMethod())
              .addMethod(getSearchUsersMethod())
              .addMethod(getUpdateUserMethod())
              .addMethod(getDeleteUserMethod())
              .addMethod(getDeactivateUserMethod())
              .build();
        }
      }
    }
    return result;
  }
}
