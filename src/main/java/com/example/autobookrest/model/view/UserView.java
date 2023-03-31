package com.example.autobookrest.model.view;

import com.example.autobookrest.model.enums.Gender;

public class UserView {
    private String username;
    private String email;
    private Gender gender;

    public UserView() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }
}
