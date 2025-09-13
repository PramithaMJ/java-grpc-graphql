# Java gRPC and GraphQL Demo

This project provides a comprehensive demonstration of integrating **gRPC** and **GraphQL** technologies in Java using Spring Boot. It showcases how to build modern, efficient APIs that leverage both technologies for different use cases.

## 🏗️ Architecture Overview

```
┌─────────────────────────────────────────────────────────────┐
│                    Java gRPC + GraphQL Demo                │
├─────────────────────────────────────────────────────────────┤
│                                                             │
│  ┌─────────────┐  ┌─────────────┐  ┌─────────────────────┐ │
│  │   REST API  │  │   GraphQL   │  │        gRPC         │ │
│  │             │  │             │  │                     │ │
│  │ Port: 8080  │  │/graphql     │  │    Port: 9090       │ │
│  │             │  │/graphiql    │  │                     │ │
│  └─────────────┘  └─────────────┘  └─────────────────────┘ │
│         │                │                        │        │
│         └────────────────┼────────────────────────┘        │
│                          │                                 │
│           ┌─────────────────────────────────┐               │
│           │        Business Logic          │               │
│           │      (User Service)            │               │
│           └─────────────────────────────────┘               │
│                          │                                 │
│           ┌─────────────────────────────────┐               │
│           │     Data Access Layer          │               │
│           │   (JPA Repository)             │               │
│           └─────────────────────────────────┘               │
│                          │                                 │
│           ┌─────────────────────────────────┐               │
│           │       H2 Database              │               │
│           │     (In-Memory)                │               │
│           └─────────────────────────────────┘               │
└─────────────────────────────────────────────────────────────┘
```

## 🚀 Features

### gRPC Service
- **High-performance** binary protocol
- **Type-safe** API with protocol buffers
- **Streaming** support (not implemented in this demo)
- **Cross-platform** compatibility
- Full CRUD operations for User management

### GraphQL Service
- **Flexible** query language
- **Single endpoint** for all operations
- **Real-time** introspection
- **GraphiQL** playground for testing
- Type-safe schema definition

### Shared Features
- **Spring Boot** integration
- **JPA/Hibernate** data persistence
- **H2** in-memory database
- **Comprehensive** error handling
- **Sample data** initialization
- **REST API** for gRPC demonstration

## 📁 Project Structure

```
java-grpc/
├── common/                          # Shared domain models and services
│   ├── src/main/java/com/example/common/
│   │   ├── model/User.java         # JPA entity
│   │   ├── repository/UserRepository.java
│   │   └── service/UserService.java
│   └── src/test/java/              # Unit tests
├── grpc-service/                   # gRPC implementation
│   ├── src/main/proto/             # Protocol buffer definitions
│   │   └── user_service.proto
│   ├── src/main/java/com/example/grpc/
│   │   ├── service/UserGrpcService.java   # gRPC server implementation
│   │   └── client/UserGrpcClient.java     # gRPC client
│   └── target/generated-sources/   # Generated gRPC stubs
├── graphql-service/                # GraphQL implementation
│   ├── src/main/resources/
│   │   └── schema.graphqls         # GraphQL schema
│   └── src/main/java/com/example/graphql/
│       ├── resolver/               # Query and Mutation resolvers
│       └── dto/                    # Input/Output DTOs
├── application/                    # Main Spring Boot application
│   ├── src/main/java/com/example/app/
│   │   ├── JavaGrpcGraphqlApplication.java
│   │   ├── controller/             # REST controllers
│   │   └── config/                 # Configuration classes
│   └── src/main/resources/
│       └── application.properties  # Configuration
└── pom.xml                         # Maven parent POM
```

## 🛠️ Technologies Used

- **Java 11**
- **Spring Boot 2.7.14**
- **gRPC 1.51.0** with Spring Boot Starter
- **GraphQL Java 19.2** with Spring Boot Kickstart
- **Protocol Buffers 3.21.7**
- **Spring Data JPA**
- **H2 Database**
- **Maven** (multi-module project)
- **JUnit 5** for testing

## 🚀 Getting Started

### Prerequisites
- Java 11 or higher
- Maven 3.6+

### Running the Application

1. **Clone the repository:**
   ```bash
   git clone <repository-url>
   cd java-grpc
   ```

2. **Build the project:**
   ```bash
   mvn clean compile
   ```

3. **Run tests:**
   ```bash
   mvn test
   ```

4. **Start the application:**
   ```bash
   mvn spring-boot:run -pl application
   ```

The application will start with:
- **REST API**: http://localhost:8080
- **GraphQL endpoint**: http://localhost:8080/graphql
- **GraphiQL playground**: http://localhost:8080/graphiql
- **gRPC server**: localhost:9090
- **H2 Console**: http://localhost:8080/h2-console

## 📋 API Examples

### REST API (gRPC Client Demo)

#### Get Service Information
```bash
curl http://localhost:8080/api/info
```

#### Create User via gRPC
```bash
curl -X POST http://localhost:8080/api/grpc/users \
  -H "Content-Type: application/json" \
  -d '{
    "username": "newuser",
    "email": "newuser@example.com",
    "firstName": "New",
    "lastName": "User",
    "phoneNumber": "+1234567890"
  }'
```

#### Get User by ID via gRPC
```bash
curl http://localhost:8080/api/grpc/users/1
```

#### Search Users via gRPC
```bash
curl "http://localhost:8080/api/grpc/users/search?searchTerm=john"
```

### GraphQL API

Visit http://localhost:8080/graphiql for interactive testing.

#### Query Examples

**Get all users:**
```graphql
query {
  allUsers {
    id
    username
    email
    firstName
    lastName
    active
    createdAt
  }
}
```

**Get user by ID:**
```graphql
query {
  user(id: "1") {
    id
    username
    email
    firstName
    lastName
    phoneNumber
    active
    createdAt
  }
}
```

**Search users:**
```graphql
query {
  searchUsers(searchTerm: "john") {
    id
    username
    firstName
    lastName
    email
  }
}
```

#### Mutation Examples

**Create user:**
```graphql
mutation {
  createUser(input: {
    username: "graphql_user"
    email: "graphql@example.com"
    firstName: "GraphQL"
    lastName: "User"
    phoneNumber: "+1987654321"
  }) {
    success
    message
    user {
      id
      username
      email
    }
  }
}
```

**Update user:**
```graphql
mutation {
  updateUser(id: "1", input: {
    firstName: "Updated"
    phoneNumber: "+1111111111"
  }) {
    success
    message
    user {
      id
      firstName
      phoneNumber
    }
  }
}
```

### gRPC API

For gRPC testing, you can use tools like [grpcurl](https://github.com/fullstorydev/grpcurl) or [BloomRPC](https://github.com/uw-labs/bloomrpc).

#### List available services:
```bash
grpcurl -plaintext localhost:9090 list
```

#### Create user:
```bash
grpcurl -plaintext -d '{
  "username": "grpc_user",
  "email": "grpc@example.com",
  "first_name": "gRPC",
  "last_name": "User"
}' localhost:9090 com.example.grpc.UserService/CreateUser
```

## 🧪 Sample Data

The application initializes with sample users:
- **john_doe** (john.doe@example.com)
- **jane_smith** (jane.smith@example.com)
- **bob_johnson** (bob.johnson@example.com)
- **alice_brown** (alice.brown@example.com)
- **charlie_wilson** (charlie.wilson@example.com) - *deactivated*

## 🏗️ Key Design Decisions

### Why gRPC?
- **Performance**: Binary serialization is faster than JSON
- **Type Safety**: Strong typing with protocol buffers
- **Code Generation**: Automatic client/server stub generation
- **Streaming**: Built-in support for real-time communication
- **Cross-platform**: Language agnostic

### Why GraphQL?
- **Flexibility**: Clients request exactly what they need
- **Single Endpoint**: Reduced API surface area
- **Type System**: Strong schema definition
- **Introspection**: Self-documenting APIs
- **Developer Experience**: Excellent tooling (GraphiQL)

### Integration Benefits
- **Best of Both Worlds**: Use gRPC for internal services, GraphQL for client-facing APIs
- **Shared Business Logic**: Common service layer for both APIs
- **Consistent Data Model**: Single source of truth for domain models

## 🧪 Testing

The project includes:
- **Unit tests** for service layer
- **Integration tests** can be added for gRPC and GraphQL endpoints
- **Test data** setup with H2 in-memory database

Run tests with:
```bash
mvn test
```

## 📊 Monitoring and Observability

The application includes:
- **Detailed logging** for all operations
- **Health check** endpoints
- **H2 console** for database inspection
- **gRPC reflection** (can be enabled)

## 🔧 Configuration

Key configuration in `application.properties`:
- Database settings (H2)
- gRPC server port (9090)
- GraphQL endpoint paths
- Logging levels

## 📈 Performance Considerations

- **gRPC**: Binary protocol, HTTP/2, efficient serialization
- **GraphQL**: Single request, precise data fetching
- **JPA**: Optimized queries with proper indexing
- **Connection Pooling**: Configured for production use

## 🛡️ Security Considerations

For production deployment, consider:
- **Authentication** (JWT, OAuth2)
- **Authorization** (role-based access control)
- **Input validation** (Bean Validation)
- **Rate limiting**
- **HTTPS/TLS** for gRPC and GraphQL
- **CORS** configuration

## 🚀 Deployment

The application can be deployed as:
- **JAR file**: `java -jar application/target/application-1.0.0.jar`
- **Docker container**: Add Dockerfile for containerization
- **Kubernetes**: Add deployment manifests
- **Cloud platforms**: Heroku, AWS, GCP, Azure

## 📚 Learning Resources

- [gRPC Documentation](https://grpc.io/docs/)
- [GraphQL Specification](https://spec.graphql.org/)
- [Spring Boot gRPC Starter](https://github.com/yidongnan/grpc-spring-boot-starter)
- [GraphQL Java Kickstart](https://www.graphql-java-kickstart.com/)

## 🤝 Contributing

1. Fork the repository
2. Create a feature branch
3. Add tests for new functionality
4. Ensure all tests pass
5. Submit a pull request

## 📄 License

This project is for educational purposes and demonstrates integration patterns for gRPC and GraphQL in Java.