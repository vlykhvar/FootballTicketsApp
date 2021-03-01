package com.dev.theater.config;

import com.dev.theater.model.Role;
import com.dev.theater.model.User;
import com.dev.theater.service.RoleService;
import com.dev.theater.service.UserService;
import java.util.Set;
import javax.annotation.PostConstruct;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer {
    private final RoleService roleService;
    private final UserService userService;

    public DataInitializer(RoleService roleService, UserService userService) {
        this.roleService = roleService;
        this.userService = userService;
    }

    @PostConstruct
    public void dataStartInitialize() {
        addAdmin();
        addUser();
    }

    private void addAdmin() {
        Role roleAdmin = new Role();
        roleAdmin.setRoleName("ADMIN");
        roleService.add(roleAdmin);
        User admin = new User();
        admin.setEmail("admin");
        admin.setPassword("123");
        admin.setRoles(Set.of(roleAdmin));
        userService.add(admin);
    }

    private void addUser() {
        Role roleUser = new Role();
        roleUser.setRoleName("USER");
        roleService.add(roleUser);
        User user = new User();
        user.setEmail("user");
        user.setPassword("123");
        user.setRoles(Set.of(roleUser));
        userService.add(user);
    }
}
