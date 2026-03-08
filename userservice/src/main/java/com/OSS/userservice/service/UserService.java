package com.OSS.userservice.service;

import com.OSS.userservice.DTO.LoginUser;
import com.OSS.userservice.DTO.RegisterUser;
import com.OSS.userservice.model.User;
import com.OSS.userservice.repository.UserRepository;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public User registerUser(RegisterUser registerUser) {

        Optional<Object> existingUser =
                userRepository.findByEmail(registerUser.getEmail());

        if (existingUser.isPresent()) {
            throw new RuntimeException("User email already exists");
        }

        User newUser = new User();
        newUser.setUserName(registerUser.getUserName());
        newUser.setPassword(registerUser.getPassword()); // encode later
        newUser.setEmail(registerUser.getEmail());
        newUser.setPhoneNo(Long.valueOf(registerUser.getPhoneNo()));

        return userRepository.save(newUser);
    }

    public List<User> getAllusers() {
        List<User> users = userRepository.findAll();
        return users;
    }

    public Optional<User> getuser(Long id) {
        Optional<User> user = userRepository.findById(id);
        return user;
    }
}

