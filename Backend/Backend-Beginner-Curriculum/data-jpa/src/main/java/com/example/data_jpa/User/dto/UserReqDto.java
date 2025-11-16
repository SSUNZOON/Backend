package com.example.data_jpa.User.dto;

import lombok.Getter;

@Getter
public class UserReqDto { //회원가입 요청 DTO
  private String name; 

  public UserReqDto() {} //디폴트 생성자
  public UserReqDto(String name) {this.name = name;} 
}