package com.OSS.userservice.controller;

import com.OSS.userservice.DTO.LoginUser;
import com.OSS.userservice.DTO.RegisterUser;
import com.OSS.userservice.DTO.UserResponseDto;
import com.OSS.userservice.model.User;
import com.OSS.userservice.repository.UserRepository;
import com.OSS.userservice.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequiredArgsConstructor
@RequestMapping("/api/user")
public class UserController {

    private final UserService userService;

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(
            @Valid @RequestBody RegisterUser request) {

        userService.registerUser(request);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("User registered successfully");
    }

    @GetMapping("/getAllUsers")
    public ResponseEntity<List<UserResponseDto>> getAllusers() {

        List<UserResponseDto> users = userService.getAllusers()
                .stream()
                .map(user -> UserResponseDto.builder()
                        .userId(user.getUserId())
                        .userName(user.getUserName())
                        .phoneNo(user.getPhoneNo())
                        .email(user.getEmail())
                        .role(user.getRole())
                        .build())
                .toList();

        return ResponseEntity.ok(users);
    }

    @GetMapping("/getUser/{id}")
    public ResponseEntity<UserResponseDto> getuser(@PathVariable Long id) {

        return userService.getuser(id)
                .map(user -> UserResponseDto.builder()
                        .userId(user.getUserId())
                        .userName(user.getUserName())
                        .phoneNo(user.getPhoneNo())
                        .email(user.getEmail())
                        .role(user.getRole())
                        .build())
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
