package com.example.demo.repository;

import com.example.demo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    /**
     * Find user by {@param username}.
     *
     * @param username of the user to be found.
     * @return an optional user.
     */
    Optional<User> findByUsername(String username);
}
