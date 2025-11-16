package com.example.data_jpa.User.entity;

import java.time.LocalDate;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
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
  @Column(length = 50) //varchar(255) 길이 제한 
  private Long id; 
  private String name;

  protected User() {}
  public User(String name) {
    this.name = name;
  }

  @CreationTimestamp
  private LocalDate createdAt;

  @UpdateTimestamp
  private LocalDate updatedAt;
  
  @Version //동시성 제어를 위한 낙관적 락
  private Long version; 
}

