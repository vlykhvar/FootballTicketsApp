package com.dev.theater.dao;

import com.dev.theater.model.Role;

public interface RoleDao extends GenericDao<Role> {
    Role getRoleByName(String roleName);
}
