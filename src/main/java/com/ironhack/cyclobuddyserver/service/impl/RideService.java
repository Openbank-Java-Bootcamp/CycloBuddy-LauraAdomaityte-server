package com.ironhack.cyclobuddyserver.service.impl;

import com.google.gson.Gson;
import com.ironhack.cyclobuddyserver.DTO.RideDTO;
import com.ironhack.cyclobuddyserver.DTO.UserVerifyDTO;
import com.ironhack.cyclobuddyserver.model.Ride;
import com.ironhack.cyclobuddyserver.model.User;
import com.ironhack.cyclobuddyserver.repository.RideRepository;
import com.ironhack.cyclobuddyserver.repository.UserRepository;
import com.ironhack.cyclobuddyserver.service.interfaces.RideServiceInterface;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class RideService implements RideServiceInterface {

    @Autowired
    private RideRepository rideRepository;

    @Autowired
    private UserRepository userRepository;

    public List<Ride> getAllRides(){
        return rideRepository.findAll();
    }

    public Ride getRideById(Integer id){
        return rideRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Ride not found"));
    }

    public void saveRide(RideDTO rideDTO) {
        Ride newRide = new Ride();
        newRide.setRideDateAndTime(rideDTO.getRideDateAndTime());
        newRide.setMeetingLocation(rideDTO.getMeetingLocation());
        newRide.setClosestCity(rideDTO.getClosestCity());
        newRide.setRideDescription(rideDTO.getRideDescription());
        newRide.setUser(userRepository.findById(rideDTO.getUserId()).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found")));
        newRide.setRoute(rideDTO.getRoute());
        rideRepository.save(newRide);
    }

    public void updateRide(Integer id, Ride ride) {
        Ride rideFromDB = rideRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Ride is not found"));
        rideFromDB.setRideDateAndTime(ride.getRideDateAndTime());
        rideFromDB.setRideDescription(ride.getRideDescription());
        rideFromDB.setClosestCity(ride.getClosestCity());
        rideFromDB.setMeetingLocation(ride.getMeetingLocation());
        rideRepository.save(rideFromDB);
    }

    public void deleteRide(Integer id){
        Ride rideFromDB = rideRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Ride not found"));
        rideRepository.deleteById(id);
    }

    public List<Ride> findUserRides(Authentication authentication) {
        String email = (String) authentication.getPrincipal();
        User userFromDb = userRepository.findByEmail(email);
        UserVerifyDTO userVerifyDTO = new UserVerifyDTO(userFromDb.getId());
        return rideRepository.findRidesIdByUserId(userVerifyDTO.getId());
    }


}
