package com.example.autobookrest.security.authService;

import com.example.autobookrest.exception.NoSuchUserException;
import com.example.autobookrest.model.entity.UserEntity;
import com.example.autobookrest.model.enums.Role;
import com.example.autobookrest.service.UserService;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AuthService implements UserDetailsService {

    private final UserService userService;

    public AuthService(UserService userService) {
        this.userService = userService;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity userEntity = null;
        try {
            userEntity = this.userService.findUserByUsername(username);
        } catch (NoSuchUserException e) {
            e.printStackTrace();
        }

        List<GrantedAuthority> authorities = List.of(new SimpleGrantedAuthority("ROLE_" + Role.USER));

        return new User(
                userEntity.getUsername(),
                userEntity.getPassword(),
                authorities
        );
    }
}
