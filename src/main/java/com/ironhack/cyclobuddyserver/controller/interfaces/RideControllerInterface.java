package com.ironhack.cyclobuddyserver.controller.interfaces;

import com.ironhack.cyclobuddyserver.DTO.RideDTO;
import com.ironhack.cyclobuddyserver.model.Ride;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;
import java.util.List;

public interface RideControllerInterface {

    public List<Ride> getAllRides();

    public Ride getRideById(Integer id);

    public void addProject(@RequestBody @Valid RideDTO rideDTO);

    public void updateRide(@PathVariable Integer id, @RequestBody @Valid Ride ride);

    public void deleteRide(@PathVariable Integer id);

    public List<Ride> findUserRides(Authentication authentication);
}
