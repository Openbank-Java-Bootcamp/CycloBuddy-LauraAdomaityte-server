package com.ironhack.cyclobuddyserver.controller.interfaces;


import com.ironhack.cyclobuddyserver.model.User;
import org.springframework.web.bind.annotation.PathVariable;

public interface UserControllerInterface {

    public User getUserById(@PathVariable(name = "id") Integer userId);
}
