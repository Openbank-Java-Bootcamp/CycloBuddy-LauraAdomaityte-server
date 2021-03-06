package com.ironhack.cyclobuddyserver.controller.impl;

import com.ironhack.cyclobuddyserver.DTO.RideDTO;
import com.ironhack.cyclobuddyserver.controller.interfaces.RideControllerInterface;
import com.ironhack.cyclobuddyserver.model.Ride;
import com.ironhack.cyclobuddyserver.repository.RideRepository;
import com.ironhack.cyclobuddyserver.service.interfaces.RideServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class RideController implements RideControllerInterface {

    @Autowired
    private RideServiceInterface rideServiceInterface;

    @Autowired
    private RideRepository rideRepository;

    //get all rides endpoint
    @GetMapping("/rides")
    @ResponseStatus(HttpStatus.OK)
    public List<Ride> getAllRides(){
        return rideServiceInterface.getAllRides();
    }

    //get ride by id endpoint
    @GetMapping("/rides/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Ride getRideById(@PathVariable(name = "id")Integer id){
        return rideServiceInterface.getRideById(id);
    }

    //get user rides endpoint
    @GetMapping("/rides/user")
    @ResponseStatus(HttpStatus.OK)
    public List<Ride> findUserRides(Authentication authentication){
        return rideServiceInterface.findUserRides(authentication);
    }

    //add new ride endpoint
    @PostMapping("/rides")
    @ResponseStatus(HttpStatus.CREATED)
    public void addProject(@RequestBody RideDTO rideDTO){
        rideServiceInterface.saveRide(rideDTO);
    }

    //edit a ride endpoint
    @PutMapping("/rides/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateRide(@PathVariable Integer id, @RequestBody Ride ride){
        rideServiceInterface.updateRide(id, ride);
    }

    //delete a ride endpoint
    @DeleteMapping("/rides/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteRide(@PathVariable Integer id){
        rideServiceInterface.deleteRide(id);
    }
}
