package com.example.data_jpa.User.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class UserPageResDto { //페이징 응답 DTO
    private List<UserResDto> content;
    private int totalPages; //전체 페이지 개수
}
