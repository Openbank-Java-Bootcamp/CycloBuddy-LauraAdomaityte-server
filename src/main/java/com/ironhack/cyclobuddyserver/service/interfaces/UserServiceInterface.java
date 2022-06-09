package com.ironhack.cyclobuddyserver.service.interfaces;

import com.ironhack.cyclobuddyserver.model.User;

import java.util.List;

public interface UserServiceInterface {
    User saveUser(User userSignupDTO);

    List<User> getUsers();

    User findUserById(Integer id);
}
