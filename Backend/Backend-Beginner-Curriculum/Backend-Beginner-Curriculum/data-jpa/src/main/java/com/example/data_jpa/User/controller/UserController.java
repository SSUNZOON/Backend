package com.example.data_jpa.User.controller;

import com.example.data_jpa.User.dto.UserResDto;
import com.example.data_jpa.User.dto.UserReqDto;
import com.example.data_jpa.User.service.UserService;

import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.data.domain.Sort;

@RestController
@RequiredArgsConstructor
@RequestMapping
public class UserController {
  private final UserService userService;

  @GetMapping("/members/{id}") 
  public String getUser(@PathVariable("id")Long id){
    return userService.findUser(id).getName();
  }

  @GetMapping("/members")
  public Page<UserResDto> getAllUsers(
    @PageableDefault(sort = "createdAt", direction = Sort.Direction.DESC) Pageable pageable) {
      return userService.getUserPage(pageable).map(u-> new UserResDto(u.getId(), u.getName(), u.getCreatedAt().toString(), u.getUpdatedAt().toString()));
  }

  @PostMapping("/members")
  public UserResDto createUser(@RequestBody UserReqDto dto){
    return userService.saveUser(dto);
  }
}