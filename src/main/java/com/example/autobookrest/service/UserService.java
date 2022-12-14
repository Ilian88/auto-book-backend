package com.example.autobookrest.service;


import com.example.autobookrest.exception.NoSuchUserException;
import com.example.autobookrest.model.dto.ChangeUserRoleDTO;
import com.example.autobookrest.model.dto.UserDTO;
import com.example.autobookrest.model.dto.UserDTObody;
import com.example.autobookrest.model.entity.UserEntity;

import java.util.List;

public interface UserService {
    void registerUser(UserDTO userDto);
    UserEntity findUserByUsername(String username) throws NoSuchUserException;
    List<UserDTObody> getAllUsers();
    void changeUserRole(ChangeUserRoleDTO userDetails);
}
