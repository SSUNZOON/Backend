package com.example.data_jpa.User.entity;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Version;

import lombok.Getter;

@Entity
@Getter
public class User {
  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id; 
  
  private String name; 

  protected User() {} //디폴트 생성자
  public User(String name) {this.name = name;} 


  @CreationTimestamp //생성 시간 기록
  private LocalDateTime createdAt;
  @UpdateTimestamp //수정 시간 기록
  private LocalDateTime updatedAt;

  @Version //동시성 제어를 위한 낙관적 락
  private Long version;
}