package com.ironhack.cyclobuddyserver.controller.impl;

import com.ironhack.cyclobuddyserver.controller.interfaces.UserControllerInterface;
import com.ironhack.cyclobuddyserver.model.Ride;
import com.ironhack.cyclobuddyserver.model.User;
import com.ironhack.cyclobuddyserver.service.interfaces.UserServiceInterface;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class UserController implements UserControllerInterface {

    @Autowired
    private UserServiceInterface userServiceInterface;

    //get a user by his/her id endpoint
    @GetMapping({"/users/{id}"})
    @ResponseStatus(HttpStatus.OK)
    public User getUserById(@PathVariable(name = "id") Integer userId) {
        return this.userServiceInterface.findUserById(userId);
    }

    //edit user info endpoint
    @PutMapping("/users/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateRide(@PathVariable Integer id, @RequestBody User user){
        userServiceInterface.updateUser(id, user);
    }
}
