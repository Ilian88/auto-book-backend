package com.example.autobookrest.controller;

import com.example.autobookrest.model.dto.ChangeUserRoleDTO;
import com.example.autobookrest.model.dto.LoginDTO;
import com.example.autobookrest.model.dto.UserDTO;
import com.example.autobookrest.model.dto.UserDTObody;
import com.example.autobookrest.model.entity.UserEntity;
import com.example.autobookrest.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin
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
            this.userService.registerUser(userDTO);
            return ResponseEntity
                    .ok()
                    .build();
    }

    @PostMapping("/login")
    public ResponseEntity<UserDTObody> login(@RequestBody LoginDTO loginDTO) {
        UserDTObody user = modelMapper.map(this.userService.findUserByUsername(loginDTO.getUsername()), UserDTObody.class);

        return ResponseEntity
                .ok()
                .body(user);
    }

    @PatchMapping("/admin")
    public ResponseEntity changeRole(@RequestBody ChangeUserRoleDTO user) {
        this.userService.changeUserRole(user);

        return ResponseEntity.ok().build();
    }

    @GetMapping("")
    public ResponseEntity<List<UserDTObody>> getAllUsers() {
        List<UserDTObody> users = this.userService.getAllUsers();

        return ResponseEntity.ok().body(users);
    }
}
