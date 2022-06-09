package com.ironhack.cyclobuddyserver.controller.impl;


import com.google.gson.Gson;
import com.ironhack.cyclobuddyserver.DTO.UserVerifyDTO;
import com.ironhack.cyclobuddyserver.controller.interfaces.AuthorizationControllerInterface;
import com.ironhack.cyclobuddyserver.model.User;
import com.ironhack.cyclobuddyserver.repository.UserRepository;
import com.ironhack.cyclobuddyserver.service.interfaces.UserServiceInterface;
import javax.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthorizationController implements AuthorizationControllerInterface {

    @Autowired
    private UserServiceInterface userServiceInterface;

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/signup")
    @ResponseStatus(HttpStatus.CREATED)
    public User saveUser(@RequestBody @Valid User user) {
        return userServiceInterface.saveUser(user);
    }

    @GetMapping("/verify")
    @ResponseStatus(HttpStatus.OK)
    public String verifyToken(Authentication authentication) {
        String email = (String) authentication.getPrincipal();
        User userFromDb = userRepository.findByEmail(email);
        UserVerifyDTO userVerifyDTO = new UserVerifyDTO(userFromDb.getName());
        Gson gson = new Gson();
        String userDetails = gson.toJson(userVerifyDTO);
        return userDetails;
    }
}
