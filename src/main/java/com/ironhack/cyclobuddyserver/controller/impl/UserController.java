package com.ironhack.cyclobuddyserver.controller.impl;

import com.ironhack.cyclobuddyserver.controller.interfaces.UserControllerInterface;
import com.ironhack.cyclobuddyserver.model.User;
import com.ironhack.cyclobuddyserver.service.interfaces.UserServiceInterface;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping({"/api/users"})
public class UserController implements UserControllerInterface {

    @Autowired
    private UserServiceInterface userServiceInterface;

    public UserController() {
    }

    @GetMapping({"/{id}"})
    @ResponseStatus(HttpStatus.OK)
    public User getUserById(@PathVariable(name = "id") Integer userId) {
        return this.userServiceInterface.findUserById(userId);
    }
}
