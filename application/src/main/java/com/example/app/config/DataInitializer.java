package com.example.app.config;

import com.example.common.model.User;
import com.example.common.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * Data initialization component that creates sample users on application startup.
 */
@Component
public class DataInitializer implements CommandLineRunner {

    private static final Logger logger = LoggerFactory.getLogger(DataInitializer.class);
    
    private final UserService userService;

    @Autowired
    public DataInitializer(UserService userService) {
        this.userService = userService;
    }

    @Override
    public void run(String... args) throws Exception {
        logger.info("Initializing sample data...");
        
        try {
            // Create sample users
            User user1 = new User("john_doe", "john.doe@example.com", "John", "Doe");
            user1.setPhoneNumber("+1234567890");
            userService.createUser(user1);
            logger.info("Created user: {}", user1.getUsername());

            User user2 = new User("jane_smith", "jane.smith@example.com", "Jane", "Smith");
            user2.setPhoneNumber("+1987654321");
            userService.createUser(user2);
            logger.info("Created user: {}", user2.getUsername());

            User user3 = new User("bob_johnson", "bob.johnson@example.com", "Bob", "Johnson");
            userService.createUser(user3);
            logger.info("Created user: {}", user3.getUsername());

            User user4 = new User("alice_brown", "alice.brown@example.com", "Alice", "Brown");
            user4.setPhoneNumber("+1122334455");
            userService.createUser(user4);
            logger.info("Created user: {}", user4.getUsername());

            User user5 = new User("charlie_wilson", "charlie.wilson@example.com", "Charlie", "Wilson");
            userService.createUser(user5);
            // Deactivate one user for testing
            userService.deactivateUser(user5.getId());
            logger.info("Created and deactivated user: {}", user5.getUsername());

            logger.info("Sample data initialization completed successfully");
            
        } catch (Exception e) {
            logger.error("Error during data initialization", e);
        }
    }
}