# GraphQL Examples

This document provides detailed examples of using the GraphQL service.

## Schema Overview

```graphql
type Query {
  user(id: ID!): User
  userByUsername(username: String!): User
  allUsers(activeOnly: Boolean = false): [User!]!
  searchUsers(searchTerm: String!): [User!]!
}

type Mutation {
  createUser(input: CreateUserInput!): CreateUserPayload!
  updateUser(id: ID!, input: UpdateUserInput!): UpdateUserPayload!
  deleteUser(id: ID!): DeleteUserPayload!
  deactivateUser(id: ID!): DeactivateUserPayload!
}
```

## GraphiQL Playground

Visit http://localhost:8080/graphiql to interact with the GraphQL API using the built-in playground.

## Query Examples

### Get all users
```graphql
query GetAllUsers {
  allUsers {
    id
    username
    email
    firstName
    lastName
    phoneNumber
    active
    createdAt
    updatedAt
  }
}
```

### Get active users only
```graphql
query GetActiveUsers {
  allUsers(activeOnly: true) {
    id
    username
    firstName
    lastName
    active
  }
}
```

### Get user by ID
```graphql
query GetUserById($userId: ID!) {
  user(id: $userId) {
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

Variables:
```json
{
  "userId": "1"
}
```

### Get user by username
```graphql
query GetUserByUsername($username: String!) {
  userByUsername(username: $username) {
    id
    username
    email
    firstName
    lastName
    phoneNumber
  }
}
```

Variables:
```json
{
  "username": "john_doe"
}
```

### Search users by name
```graphql
query SearchUsers($searchTerm: String!) {
  searchUsers(searchTerm: $searchTerm) {
    id
    username
    firstName
    lastName
    email
  }
}
```

Variables:
```json
{
  "searchTerm": "john"
}
```

## Mutation Examples

### Create a new user
```graphql
mutation CreateUser($input: CreateUserInput!) {
  createUser(input: $input) {
    success
    message
    user {
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
}
```

Variables:
```json
{
  "input": {
    "username": "graphql_user",
    "email": "graphql@example.com",
    "firstName": "GraphQL",
    "lastName": "User",
    "phoneNumber": "+1987654321"
  }
}
```

### Update a user
```graphql
mutation UpdateUser($id: ID!, $input: UpdateUserInput!) {
  updateUser(id: $id, input: $input) {
    success
    message
    user {
      id
      username
      email
      firstName
      lastName
      phoneNumber
      active
      updatedAt
    }
  }
}
```

Variables:
```json
{
  "id": "1",
  "input": {
    "firstName": "Updated John",
    "phoneNumber": "+1111111111",
    "active": true
  }
}
```

### Delete a user
```graphql
mutation DeleteUser($id: ID!) {
  deleteUser(id: $id) {
    success
    message
  }
}
```

Variables:
```json
{
  "id": "5"
}
```

### Deactivate a user
```graphql
mutation DeactivateUser($id: ID!) {
  deactivateUser(id: $id) {
    success
    message
    user {
      id
      username
      active
      updatedAt
    }
  }
}
```

Variables:
```json
{
  "id": "2"
}
```

## Advanced Query Examples

### Get user with selective fields
```graphql
query GetUserBasicInfo($userId: ID!) {
  user(id: $userId) {
    username
    firstName
    lastName
    email
  }
}
```

### Multiple queries in one request
```graphql
query MultipleQueries {
  activeUsers: allUsers(activeOnly: true) {
    id
    username
    firstName
    lastName
  }
  
  johnUsers: searchUsers(searchTerm: "john") {
    id
    username
    email
  }
  
  specificUser: user(id: "1") {
    username
    email
    createdAt
  }
}
```

## Using cURL with GraphQL

### Query via cURL
```bash
curl -X POST http://localhost:8080/graphql \
  -H "Content-Type: application/json" \
  -d '{
    "query": "query { allUsers { id username firstName lastName } }"
  }'
```

### Mutation via cURL
```bash
curl -X POST http://localhost:8080/graphql \
  -H "Content-Type: application/json" \
  -d '{
    "query": "mutation($input: CreateUserInput!) { createUser(input: $input) { success message user { id username } } }",
    "variables": {
      "input": {
        "username": "curl_user",
        "email": "curl@example.com",
        "firstName": "cURL",
        "lastName": "User"
      }
    }
  }'
```

## Error Handling

GraphQL returns errors in a structured format:

```json
{
  "data": {
    "createUser": {
      "success": false,
      "message": "Failed to create user: Username already exists: john_doe",
      "user": null
    }
  }
}
```

## Introspection Queries

### Get schema information
```graphql
query IntrospectionQuery {
  __schema {
    types {
      name
      description
    }
  }
}
```

### Get specific type information
```graphql
query GetUserType {
  __type(name: "User") {
    name
    fields {
      name
      type {
        name
      }
    }
  }
}
```

## Best Practices

1. **Use Variables**: Always use variables for dynamic values
2. **Request Only Needed Fields**: Take advantage of GraphQL's selective querying
3. **Handle Errors**: Check both the `errors` array and payload-specific error fields
4. **Use Fragments**: For reusable field selections
5. **Batch Queries**: Combine multiple queries in a single request when possible

## Fragment Example

```graphql
fragment UserBasicInfo on User {
  id
  username
  firstName
  lastName
  email
}

query GetUsers {
  allUsers {
    ...UserBasicInfo
    active
  }
  
  specificUser: user(id: "1") {
    ...UserBasicInfo
    phoneNumber
    createdAt
  }
}
```