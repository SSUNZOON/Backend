package com.example.data_jpa.User.service;

import com.example.data_jpa.User.entity.User;
import com.example.data_jpa.User.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

@Service
@RequiredArgsConstructor //Lombok 어노테이션 -> final이 붙은 필드를 매개변수로 받는 생성자를 자동으로 생성
@Transactional //ACID 보장
public class UserService {

  private final UserRepository userRepository;

  @Transactional(readOnly = true) //readonly 속성 추가 -> 최적화
  public User findUser(Long id){ 
    return userRepository.findById(id).orElse(null); //Optional 처리
  } //사용자 조회
  
  @Transactional(readOnly = true) 
  public Page<User> getUserPage(Pageable pageable) {
    return userRepository.findAll(pageable);
  }
  //사용자 목록 조회 
  public User saveUser(String name){
    User newUser = new User(name);
    return userRepository.save(newUser); //저장 후 저장된 엔티티 반환
  } //사용자 생성 및 저장

}