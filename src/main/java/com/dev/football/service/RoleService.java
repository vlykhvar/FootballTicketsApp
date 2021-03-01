package com.dev.football.service;

import com.dev.football.model.Role;
import org.springframework.stereotype.Component;

@Component
public interface RoleService {
    void add(Role role);

    Role getRoleByName(String roleName);
}
