package com.ironhack.cyclobuddyserver.repository;

import com.ironhack.cyclobuddyserver.model.Ride;
import com.ironhack.cyclobuddyserver.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    //finding the user by email
    User findByEmail(String email);


}