package com.example.autobookrest.model.dto;

public class ChangeUserRoleDTO {
    private String username;
    private String role;

    public ChangeUserRoleDTO() {
    }

    public String getUsername() {
        return username;
    }

    public ChangeUserRoleDTO setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getRole() {
        return role;
    }

    public ChangeUserRoleDTO setRole(String role) {
        this.role = role;
        return this;
    }
}
