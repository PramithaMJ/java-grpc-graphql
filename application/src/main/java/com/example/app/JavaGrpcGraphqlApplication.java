package com.example.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * Main application class that integrates gRPC and GraphQL services.
 * This application demonstrates both technologies working together.
 */
@SpringBootApplication(scanBasePackages = {
        "com.example.common",
        "com.example.grpc", 
        "com.example.graphql",
        "com.example.app"
})
@EntityScan(basePackages = "com.example.common.model")
@EnableJpaRepositories(basePackages = "com.example.common.repository")
public class JavaGrpcGraphqlApplication {

    public static void main(String[] args) {
        SpringApplication.run(JavaGrpcGraphqlApplication.class, args);
    }
}