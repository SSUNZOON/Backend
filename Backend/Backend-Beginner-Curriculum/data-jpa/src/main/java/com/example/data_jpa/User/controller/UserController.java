package com.example.data_jpa.User.controller;

import com.example.data_jpa.User.dto.UserResDto;
import com.example.data_jpa.User.dto.UserReqDto;
import com.example.data_jpa.User.service.UserService;

import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

@RestController
@RequiredArgsConstructor
public class UserController {

  private final UserService userService;

  @GetMapping("/members/{id}")
  public String getUser(@PathVariable("id") Long id) {
    return userService.findUser(id).getName();
  }

  @GetMapping("/members")
  public Page<UserResDto> getAllUsers(
      @RequestParam(value = "page", defaultValue = "0") int page,
      @RequestParam(value = "size", defaultValue = "10") int size) {

    Sort sort = Sort.by(Sort.Direction.DESC, "createdAt");
    PageRequest pageRequest = PageRequest.of(page, size, sort);

    return userService.getUserPage(pageRequest).map(u -> new UserResDto(u.getId(), u.getName()));
  }

  @PostMapping("/members")
  public UserResDto createUser(@RequestBody UserReqDto req) {
    return new UserResDto(userService.saveUser(req.getName()).getId(), req.getName());
  }

}