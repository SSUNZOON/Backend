package com.example.data_jpa.User.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.example.data_jpa.User.repository.UserRepository;
import com.example.data_jpa.User.dto.UserResDto;
import com.example.data_jpa.User.dto.UserReqDto;
import com.example.data_jpa.User.entity.User;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional
public class UserService {
  private final UserRepository userRepository;

  public UserResDto saveUser(UserReqDto dto){
    User user = new User(dto.getName());
    User savedUser = userRepository.save(user); //회원 저장
    return new UserResDto(savedUser.getId(), savedUser.getName(), savedUser.getCreatedAt().toString(), savedUser.getUpdatedAt().toString());
  }

  @Transactional(readOnly = true) //readonly 속성 추가 -> 최적화
  public User findUser(Long id){ 
    return userRepository.findById(id).orElse(null); //Optional 처리
  } //사용자 조회
  
  @Transactional(readOnly = true) 
  public Page<User> getUserPage(Pageable pageable) {
    return userRepository.findAll(pageable);
  }
  //사용자 목록 조회 
}