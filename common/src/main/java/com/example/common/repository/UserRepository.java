package com.example.common.repository;

import com.example.common.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Repository interface for User entity operations.
 * This repository is shared between gRPC and GraphQL services.
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    
    /**
     * Find user by username.
     * @param username the username to search for
     * @return optional user if found
     */
    Optional<User> findByUsername(String username);
    
    /**
     * Find user by email.
     * @param email the email to search for
     * @return optional user if found
     */
    Optional<User> findByEmail(String email);
    
    /**
     * Find all active users.
     * @return list of active users
     */
    List<User> findByActiveTrue();
    
    /**
     * Find users by first name or last name containing the search term.
     * @param searchTerm the term to search for
     * @return list of matching users
     */
    @Query("SELECT u FROM User u WHERE " +
           "LOWER(u.firstName) LIKE LOWER(CONCAT('%', :searchTerm, '%')) OR " +
           "LOWER(u.lastName) LIKE LOWER(CONCAT('%', :searchTerm, '%'))")
    List<User> findByNameContaining(@Param("searchTerm") String searchTerm);
    
    /**
     * Check if username exists.
     * @param username the username to check
     * @return true if username exists, false otherwise
     */
    boolean existsByUsername(String username);
    
    /**
     * Check if email exists.
     * @param email the email to check
     * @return true if email exists, false otherwise
     */
    boolean existsByEmail(String email);
}