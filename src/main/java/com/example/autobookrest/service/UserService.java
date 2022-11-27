package com.example.autobookrest.service;


import com.example.autobookrest.exception.NoSuchUserException;
import com.example.autobookrest.model.dto.UserDTO;
import com.example.autobookrest.model.entity.UserEntity;

public interface UserService {
    void registerUser(UserDTO userDto);

    UserEntity findUserByUsername(String username) throws NoSuchUserException;
}
