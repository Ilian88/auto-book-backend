package com.example.autobookrest.model.dto;

import com.example.autobookrest.model.enums.Gender;

import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

public class UserDTO {
    private String username;
    private String email;
    private String password;
    private Gender gender;

    public UserDTO() {
    }

    @Size(min = 4, max = 20, message = "Username must be between 4 and 20 symbols")
    public String getUsername() {
        return username;
    }

    public UserDTO setUsername(String username) {
        this.username = username;
        return this;
    }

    @Email(message = "Should has valid email")
    public String getEmail() {
        return email;
    }

    public UserDTO setEmail(String email) {
        this.email = email;
        return this;
    }

    @Size(min = 4, max = 20,message = "Password must be between 4 and 20 symbols")
    public String getPassword() {
        return password;
    }

    public UserDTO setPassword(String password) {
        this.password = password;
        return this;
    }

    public Gender getGender() {
        return gender;
    }

    public UserDTO setGender(Gender gender) {
        this.gender = gender;
        return this;
    }
}
