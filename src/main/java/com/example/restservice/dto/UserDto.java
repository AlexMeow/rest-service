package com.example.restservice.dto;

public class UserDto {
    private Long userId;
    private String userName;
    private String email;
    private String password;
    private String biography;

    // Default constructor
    public UserDto() {

    }

    // Constructor
    public UserDto(Long userId, String userName, String email, String password, String biography) {
        this.userId = userId;
        this.userName = userName;
        this.email = email;
        this.password = password;
        this.biography = biography;
    }

    // Getter and setter
    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getBiography() {
        return this.biography;
    }

    public void setBiography(String Biography) {
        this.biography = biography;
    }

}
