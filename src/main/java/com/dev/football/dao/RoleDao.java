package com.dev.football.dao;

import com.dev.football.model.Role;

public interface RoleDao extends GenericDao<Role> {
    Role getRoleByName(String roleName);
}
