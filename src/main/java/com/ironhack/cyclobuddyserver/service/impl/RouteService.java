package com.ironhack.cyclobuddyserver.service.impl;

import com.ironhack.cyclobuddyserver.model.Route;
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

    public List<Route> getAllRoutes(){
        return routeRepository.findAll();
    }

    public Route getRouteById(Integer id){
        return routeRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Route not found"));
    }

}
