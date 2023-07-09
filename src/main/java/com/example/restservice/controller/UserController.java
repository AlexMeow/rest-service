package com.example.restservice.controller;

import com.example.restservice.dto.UserDto;
import com.example.restservice.service.UserService;
import com.example.restservice.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

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

    // The method for password comparing.
    @PostMapping("/compare-password")
    public ResponseEntity<String> comparePassword(@RequestBody String password) {
        // Find user and corresponding password.
        User user = userService.findByUsername("username");
        String storedPassword = user.getPassword();

        // Use BCryptPasswordEncoder to verify password.
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        boolean isMatched = passwordEncoder.matches(password, storedPassword);

        if (isMatched) {
            return ResponseEntity.ok("Password matched");
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Password not matched");
        }
    }

    // For test use, check if user info can be obtained from DB correctly.
    @GetMapping("/test")
    public ResponseEntity<UserDto> test(@RequestParam(value = "userId", defaultValue = "1") Long userId) {
        return getUserById(userId);
    }
}
