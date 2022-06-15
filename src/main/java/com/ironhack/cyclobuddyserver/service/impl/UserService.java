package com.ironhack.cyclobuddyserver.service.impl;

import com.ironhack.cyclobuddyserver.model.Ride;
import com.ironhack.cyclobuddyserver.model.User;
import com.ironhack.cyclobuddyserver.repository.RoleRepository;
import com.ironhack.cyclobuddyserver.repository.UserRepository;
import com.ironhack.cyclobuddyserver.service.interfaces.UserServiceInterface;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
@Slf4j
public class UserService implements UserServiceInterface, UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private RoleRepository roleRepository;

    public User saveUser(User userSignupDTO) {
        log.info("Saving a new user {} inside of the database", userSignupDTO.getName());
        User user = new User(userSignupDTO.getName(), userSignupDTO.getEmail(), userSignupDTO.getPassword());
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    //optional for getting all the users
    public List<User> getUsers() {
        log.info("Fetching all users");
        return userRepository.findAll();
    }

    //this comes from Spring security
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(email);
        if (user == null) {
            log.error("User not found in the database");
            throw new UsernameNotFoundException("User not found in the database");
        } else {
            log.info("User is found in the database: {}", email);
            Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
            user.getRoles().forEach(role -> {
                authorities.add(new SimpleGrantedAuthority(role.getName()));
            });
            return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), authorities);
        }
    }

    public User findUserById(Integer id) {
        return (User)this.userRepository.findById(id).orElseThrow(() -> {
            return new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found");
        });
    }

    //update user info
    public void updateUser(Integer id, User user) {
        User userFromDB = userRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "User was not found"));
        userFromDB.setCity(user.getCity());
        userFromDB.setAverageSpeed(user.getAverageSpeed());
        userFromDB.setAverageKmPerMonth(user.getAverageKmPerMonth());
        userFromDB.setBicycleType(user.getBicycleType());
        userRepository.save(userFromDB);
    }
}
