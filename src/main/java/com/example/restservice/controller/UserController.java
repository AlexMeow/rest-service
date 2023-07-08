package com.example.restservice.controller;

import com.example.restservice.dto.UserDto;
import com.example.restservice.service.UserService;
import com.example.restservice.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/users/{userId}")
    public ResponseEntity<UserDto> getUserById(@PathVariable Long userId) {
        User user = userService.getUserById(userId);

            // Transfer User entity to UserDto
            UserDto userDto = new UserDto();
            userDto.setUserId(user.getUserId());
            userDto.setUserName(user.getUserName());
            userDto.setEmail(user.getEmail());
//            userDto.setPassword(user.getPassword());
            userDto.setBiography(user.getBiography());

            return ResponseEntity.ok(userDto);
    }

    // TEST
    @GetMapping("/test")
    public ResponseEntity<UserDto> test(@RequestParam(value = "userId", defaultValue = "1") Long userId) {
        return getUserById(userId);
    }
}
