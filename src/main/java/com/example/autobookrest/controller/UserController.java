package com.example.autobookrest.controller;

import com.example.autobookrest.model.dto.LoginDTO;
import com.example.autobookrest.model.dto.UserDTO;
import com.example.autobookrest.model.dto.UserDTObody;
import com.example.autobookrest.model.entity.UserEntity;
import com.example.autobookrest.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/users")
public class UserController{
    private final UserService userService;
    private final ModelMapper modelMapper;


    public UserController(UserService userService, ModelMapper modelMapper) {
        this.userService = userService;
        this.modelMapper = modelMapper;
    }

    @PostMapping("/register")
    public ResponseEntity<UserEntity> registerUser(@RequestBody @Valid UserDTO userDTO) {
        try {
            this.userService.registerUser(userDTO);
            return ResponseEntity
                    .ok()
                    .build();
        } catch (Exception ex) {
            return ResponseEntity
                    .badRequest()
                    .build();
        }
    }

    @PostMapping("/login")
    public ResponseEntity<UserDTObody> login(@RequestBody LoginDTO loginDTO) {
        UserDTObody user = modelMapper.map(this.userService.findUserByUsername(loginDTO.getUsername()), UserDTObody.class);

        return ResponseEntity
                .ok()
                .body(user);
    }
}
