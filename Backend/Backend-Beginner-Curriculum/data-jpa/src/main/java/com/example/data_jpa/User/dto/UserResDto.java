package com.example.data_jpa.User.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class UserResDto { //단건 회원 응답 DTO
    private Long id;
    private String name;

}
