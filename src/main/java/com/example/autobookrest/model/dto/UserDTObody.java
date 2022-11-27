package com.example.autobookrest.model.dto;

import com.example.autobookrest.model.enums.Gender;
import com.example.autobookrest.model.enums.Role;

public class UserDTObody {
    private int id;
    private String username;
    private String email;
    private Gender gender;
    private Role role;

    public int getId() {
        return id;
    }

    public UserDTObody setId(int id) {
        this.id = id;
        return this;
    }

    public UserDTObody() {
    }

    public String getUsername() {
        return username;
    }

    public UserDTObody setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public UserDTObody setEmail(String email) {
        this.email = email;
        return this;
    }

    public Gender getGender() {
        return gender;
    }

    public UserDTObody setGender(Gender gender) {
        this.gender = gender;
        return this;
    }

    public Role getRole() {
        return role;
    }

    public UserDTObody setRole(Role role) {
        this.role = role;
        return this;
    }
}
