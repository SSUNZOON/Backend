package com.example.data_jpa.User.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.example.data_jpa.User.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findById(Long id); //고유번호로 조회
    //Optional<>을 사용하여 NullPointerException
    
    Page<User> findAll(Pageable pageable);  // JpaRepository에서 자동 상속
}
