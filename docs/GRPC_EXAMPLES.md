# gRPC Examples

This document provides detailed examples of using the gRPC service.

## Protocol Buffer Definition

```protobuf
service UserService {
  rpc CreateUser(CreateUserRequest) returns (CreateUserResponse);
  rpc GetUser(GetUserRequest) returns (GetUserResponse);
  rpc GetUserByUsername(GetUserByUsernameRequest) returns (GetUserResponse);
  rpc GetAllUsers(GetAllUsersRequest) returns (GetAllUsersResponse);
  rpc SearchUsers(SearchUsersRequest) returns (SearchUsersResponse);
  rpc UpdateUser(UpdateUserRequest) returns (UpdateUserResponse);
  rpc DeleteUser(DeleteUserRequest) returns (DeleteUserResponse);
  rpc DeactivateUser(DeactivateUserRequest) returns (DeactivateUserResponse);
}
```

## Using grpcurl

### List available services
```bash
grpcurl -plaintext localhost:9090 list
```

### Get service description
```bash
grpcurl -plaintext localhost:9090 describe com.example.grpc.UserService
```

### Create a user
```bash
grpcurl -plaintext -d '{
  "username": "grpc_test",
  "email": "grpc@test.com",
  "first_name": "gRPC",
  "last_name": "Test",
  "phone_number": "+1234567890"
}' localhost:9090 com.example.grpc.UserService/CreateUser
```

### Get user by ID
```bash
grpcurl -plaintext -d '{"id": 1}' localhost:9090 com.example.grpc.UserService/GetUser
```

### Get all users
```bash
grpcurl -plaintext -d '{"active_only": false}' localhost:9090 com.example.grpc.UserService/GetAllUsers
```

### Search users
```bash
grpcurl -plaintext -d '{"search_term": "john"}' localhost:9090 com.example.grpc.UserService/SearchUsers
```

## Java gRPC Client Example

```java
// Create a channel
ManagedChannel channel = ManagedChannelBuilder
    .forAddress("localhost", 9090)
    .usePlaintext()
    .build();

// Create a blocking stub
UserServiceGrpc.UserServiceBlockingStub stub = UserServiceGrpc.newBlockingStub(channel);

// Create a user
CreateUserRequest request = CreateUserRequest.newBuilder()
    .setUsername("java_client")
    .setEmail("java@client.com")
    .setFirstName("Java")
    .setLastName("Client")
    .build();

CreateUserResponse response = stub.createUser(request);
System.out.println("Created user: " + response.getUser().getUsername());

// Clean up
channel.shutdown();
```

## Python gRPC Client Example

First, generate Python stubs from the proto file:
```bash
python -m grpc_tools.protoc \
    --proto_path=grpc-service/src/main/proto \
    --python_out=. \
    --grpc_python_out=. \
    user_service.proto
```

Then use the client:
```python
import grpc
import user_service_pb2
import user_service_pb2_grpc

# Create a channel
channel = grpc.insecure_channel('localhost:9090')
stub = user_service_pb2_grpc.UserServiceStub(channel)

# Create a user
request = user_service_pb2.CreateUserRequest(
    username='python_client',
    email='python@client.com',
    first_name='Python',
    last_name='Client'
)

response = stub.CreateUser(request)
print(f"Created user: {response.user.username}")
```

## Error Handling

The gRPC service provides detailed error information:

```bash
# Try to create user with existing username
grpcurl -plaintext -d '{
  "username": "john_doe",
  "email": "another@email.com",
  "first_name": "Another",
  "last_name": "User"
}' localhost:9090 com.example.grpc.UserService/CreateUser

# Response will include error details
{
  "success": false,
  "message": "Failed to create user: Username already exists: john_doe"
}
```