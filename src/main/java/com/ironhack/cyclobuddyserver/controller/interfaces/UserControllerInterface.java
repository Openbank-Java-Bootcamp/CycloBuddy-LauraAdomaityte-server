package com.ironhack.cyclobuddyserver.controller.interfaces;


import com.ironhack.cyclobuddyserver.model.User;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

public interface UserControllerInterface {

    public User getUserById(@PathVariable(name = "id") Integer userId);

    public void updateRide(@PathVariable Integer id, @RequestBody User user);
}
