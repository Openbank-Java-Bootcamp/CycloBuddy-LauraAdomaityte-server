package com.ironhack.cyclobuddyserver.repository;

import com.ironhack.cyclobuddyserver.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {

    //roles are not being used in this api
    Role findByName(String name);
}
