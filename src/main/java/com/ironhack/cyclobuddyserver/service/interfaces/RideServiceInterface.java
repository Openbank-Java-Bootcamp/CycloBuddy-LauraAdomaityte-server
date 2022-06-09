package com.ironhack.cyclobuddyserver.service.interfaces;

import com.ironhack.cyclobuddyserver.DTO.RideDTO;
import com.ironhack.cyclobuddyserver.model.Ride;
import org.springframework.security.core.Authentication;

import java.util.List;

public interface RideServiceInterface {

    public List<Ride> getAllRides();

    public Ride getRideById(Integer id);

    public void saveRide(RideDTO rideDTO);

    public void updateRide(Integer id, Ride ride);

    public void deleteRide(Integer id);

    public List<Ride> findUserRides(Authentication authentication);

}
