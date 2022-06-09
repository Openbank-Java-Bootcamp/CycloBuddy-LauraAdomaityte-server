package com.ironhack.cyclobuddyserver.service.impl;

import com.ironhack.cyclobuddyserver.model.Role;
import com.ironhack.cyclobuddyserver.model.User;
import com.ironhack.cyclobuddyserver.repository.RoleRepository;
import com.ironhack.cyclobuddyserver.repository.UserRepository;
import com.ironhack.cyclobuddyserver.service.interfaces.RoleServiceInterface;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class RoleService implements RoleServiceInterface {

    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private UserRepository userRepository;

    public RoleService() {
    }

    public Role saveRole(Role role) {
        log.info("Saving a new role {} to the database", role.getName());
        return (Role)this.roleRepository.save(role);
    }

    public void addRoleToUser(String email, String roleName) {
        User user = this.userRepository.findByEmail(email);
        Role role = this.roleRepository.findByName(roleName);
        user.getRoles().add(role);
        this.userRepository.save(user);
    }
}
