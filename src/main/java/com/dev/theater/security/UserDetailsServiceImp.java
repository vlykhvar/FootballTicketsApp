package com.dev.theater.security;

import com.dev.theater.model.Role;
import com.dev.theater.model.User;
import com.dev.theater.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImp implements UserDetailsService {
    private UserService userService;

    @Autowired
    public UserDetailsServiceImp(UserService userService) {
        this.userService = userService;
    }

    public UserDetailsServiceImp() {
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userService.findByEmail(email).orElseThrow();
        UserBuilder userBuilder;
        userBuilder = org.springframework.security.core.userdetails
                .User.withUsername(user.getEmail());
        userBuilder.password(new BCryptPasswordEncoder().encode(user.getPassword()));
        userBuilder.roles(user.getRoleName().stream()
                .map(Role::getRoleName).toArray(String[]::new));
        return userBuilder.build();
    }
}
