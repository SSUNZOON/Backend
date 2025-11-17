package com.example.data_jpa.User.dto;

import java.util.List;

import lombok.Getter;

@Getter
public class UserPageResDto { //페이징 응답 DTO
    private List<UserResDto> content;
    private int totalPages; //전체 페이지 개수
    private long totalElements; //전체 데이터 개수
    private int currentPage; //현재 페이지 번호
    private int pageSize; //페이지 당 데이터 개수

    public UserPageResDto() {} //디폴트 생성자  
    public UserPageResDto(List<UserResDto> content, int totalPages, long totalElements, int currentPage, int pageSize) {
        this.content = content;
        this.totalPages = totalPages;
        this.totalElements = totalElements;
        this.currentPage = currentPage;
        this.pageSize = pageSize;
    }
}
