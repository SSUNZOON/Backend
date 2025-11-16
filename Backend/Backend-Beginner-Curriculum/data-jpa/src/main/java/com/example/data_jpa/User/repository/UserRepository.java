package com.example.data_jpa.User.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.data_jpa.User.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByName(String name);
    boolean existsByName(String name);
}
