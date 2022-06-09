package com.ironhack.cyclobuddyserver.controller.interfaces;

import com.ironhack.cyclobuddyserver.model.User;
import javax.validation.Valid;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.RequestBody;

public interface AuthorizationControllerInterface {
    User saveUser(@RequestBody @Valid User user);

    String verifyToken(Authentication authentication);
}
