package com.example.data_jpa.User.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;

@Getter
public class UserResDto { //단건 회원 응답 DTO
    @JsonProperty("id")
    private Long id;

    @JsonProperty("name")
    private String name; 
    
    @JsonProperty("created_at")
    private String createdAt;

    @JsonProperty("updated_at")
    private String updatedAt;

    public UserResDto() {} //디폴트 생성자
    public UserResDto(Long id, String name, String createdAt, String updatedAt) {
        this.id = id;
        this.name = name;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }
}

