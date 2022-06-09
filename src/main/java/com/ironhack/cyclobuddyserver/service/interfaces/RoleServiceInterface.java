package com.ironhack.cyclobuddyserver.service.interfaces;

import com.ironhack.cyclobuddyserver.model.Role;

public interface RoleServiceInterface {
    Role saveRole(Role role);

    void addRoleToUser(String email, String roleName);
}
