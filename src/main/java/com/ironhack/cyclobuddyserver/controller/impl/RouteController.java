package com.ironhack.cyclobuddyserver.controller.impl;

import com.ironhack.cyclobuddyserver.DTO.RouteDTO;
import com.ironhack.cyclobuddyserver.controller.interfaces.RouteControllerInterface;
import com.ironhack.cyclobuddyserver.model.Route;
import com.ironhack.cyclobuddyserver.service.interfaces.RouteServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class RouteController implements RouteControllerInterface {

    @Autowired
    private RouteServiceInterface routeServiceInterface;

    //get all routes endpoint
    @GetMapping("/routes")
    @ResponseStatus(HttpStatus.OK)
    public List<Route> getAllRoutes(){
        return routeServiceInterface.getAllRoutes();
    }

    //get a route by id endpoint
    @GetMapping("/routes/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Route getRouteById(@PathVariable(name = "id") Integer id){
        return routeServiceInterface.getRouteById(id);
    }

    //save a new route endpoint
    @PostMapping("/routes")
    @ResponseStatus(HttpStatus.CREATED)
    public void saveTask(@RequestBody RouteDTO routeDTO){
        routeServiceInterface.saveRoute(routeDTO);
    }
}
