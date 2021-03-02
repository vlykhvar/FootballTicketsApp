package com.dev.football.security;

import com.dev.football.model.Role;
import com.dev.football.model.User;
import com.dev.football.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    private final UserService userService;

    @Autowired
    public UserDetailsServiceImpl(UserService userService) {
        this.userService = userService;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userService.findByEmail(email).orElseThrow();
        UserBuilder userBuilder;
        userBuilder = org.springframework.security.core.userdetails
                .User.withUsername(user.getEmail());
        userBuilder.password(user.getPassword());
        userBuilder.roles(user.getRoles().stream()
                .map(Role::getRoleName).toArray(String[]::new));
        return userBuilder.build();
    }
}
