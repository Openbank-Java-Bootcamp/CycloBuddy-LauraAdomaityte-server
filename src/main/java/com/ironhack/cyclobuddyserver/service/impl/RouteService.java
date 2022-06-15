package com.ironhack.cyclobuddyserver.service.impl;

import com.ironhack.cyclobuddyserver.DTO.RouteDTO;
import com.ironhack.cyclobuddyserver.model.Ride;
import com.ironhack.cyclobuddyserver.model.Route;
import com.ironhack.cyclobuddyserver.repository.RideRepository;
import com.ironhack.cyclobuddyserver.repository.RouteRepository;
import com.ironhack.cyclobuddyserver.service.interfaces.RouteServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class RouteService implements RouteServiceInterface {

    @Autowired
    private RouteRepository routeRepository;

    @Autowired
    private RideRepository rideRepository;

    public List<Route> getAllRoutes(){
        return routeRepository.findAll();
    }

    public Route getRouteById(Integer id){
        return routeRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Route not found"));
    }

    public void saveRoute(RouteDTO routeDTO){
        Route newRoute = new Route();
        newRoute.setDistance(routeDTO.getDistance());
        newRoute.setElevationGain(routeDTO.getElevationGain());
        newRoute.setEstimatedRouteDuration(routeDTO.getEstimatedRouteDuration());
        newRoute.setStartPlace(routeDTO.getStartPlace());
        newRoute.setEndPlace(routeDTO.getEndPlace());
        newRoute.setBicycleType(routeDTO.getBicycleType());
        newRoute.setRideAssigned(rideRepository.findById(routeDTO.getRideAssigned()).get().getId());
        routeRepository.save(newRoute);
        Ride updatedRide = rideRepository.findById(routeDTO.getRideAssigned()).get();
        updatedRide.setRoute(routeRepository.findById(newRoute.getId()).get());
        rideRepository.save(updatedRide);


    }


}
