package com.dev.theater.service;

import com.dev.theater.model.Role;
import org.springframework.stereotype.Component;

@Component
public interface RoleService {
    void add(Role role);

    Role getRoleByName(String roleName);
}
