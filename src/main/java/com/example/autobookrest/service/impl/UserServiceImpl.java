package com.example.autobookrest.service.impl;

import com.example.autobookrest.exception.NoSuchUserException;
import com.example.autobookrest.exception.UserAlreadyExistsException;
import com.example.autobookrest.model.dto.ChangeUserRoleDTO;
import com.example.autobookrest.model.dto.UserDTO;
import com.example.autobookrest.model.dto.UserDTObody;
import com.example.autobookrest.model.entity.UserEntity;
import com.example.autobookrest.model.enums.Role;
import com.example.autobookrest.repository.UserRepository;
import com.example.autobookrest.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

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
        checkIfUserAlreadyExists(userDTO);
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        UserEntity user = modelMapper.map(userDTO, UserEntity.class);
        user.setPassword(encoder.encode(user.getPassword()));
        user.setRole(Role.USER);

        this.userRepository.save(user);
    }

    @Override
    public UserEntity findUserByUsername(String username) throws NoSuchUserException {
        return this.userRepository.findByUsername(username)
                .orElseThrow(()-> new NoSuchUserException("There is no such user"));
    }

    @Override
    public List<UserDTObody> getAllUsers() {
        return this.userRepository.findAll()
                .stream().map(user -> {
                    return modelMapper.map(user, UserDTObody.class);
                })
                .collect(Collectors.toList());
    }

    @Override
    public void changeUserRole(ChangeUserRoleDTO userDetails) {
        UserEntity user = this.userRepository.findByUsername(userDetails.getUsername()).orElseThrow();

        user.setRole(Role.valueOf(userDetails.getRole()));

        this.userRepository.save(user);
    }


    private void checkIfUserAlreadyExists(UserDTO user) {
         try {
             this.userRepository
                     .findByUsername(user.getUsername()).orElseThrow();
             throw new UserAlreadyExistsException("User with that username already exists");
         } catch (NoSuchElementException ex) {

         }

    }
}
