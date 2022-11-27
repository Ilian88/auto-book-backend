package com.example.autobookrest.service.impl;

import com.example.autobookrest.exception.NoSuchUserException;
import com.example.autobookrest.model.dto.UserDTO;
import com.example.autobookrest.model.entity.UserEntity;
import com.example.autobookrest.model.enums.Role;
import com.example.autobookrest.repository.UserRepository;
import com.example.autobookrest.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public void registerUser(UserDTO userDTO) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        UserEntity user = modelMapper.map(userDTO, UserEntity.class);
        user.setPassword(encoder.encode(user.getPassword()));
        user.setRole(Role.USER);
//        checkIfUserAlreadyExists(user);
        this.userRepository.save(user);
    }

    @Override
    public UserEntity findUserByUsername(String username) throws NoSuchUserException {
        return this.userRepository.findByUsername(username)
                .orElseThrow(()-> new NoSuchUserException("There is no such user"));
    }

//    private void checkIfUserAlreadyExists(UserEntity user) {
//        this.userRepository
//                .findByUsername(user.getUsername())
//                .orElseThrow()
//
//    }
}