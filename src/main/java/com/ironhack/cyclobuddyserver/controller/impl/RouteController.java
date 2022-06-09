package com.ironhack.cyclobuddyserver.controller.impl;

import com.ironhack.cyclobuddyserver.controller.interfaces.RouteControllerInterface;
import com.ironhack.cyclobuddyserver.model.Route;
import com.ironhack.cyclobuddyserver.service.interfaces.RouteServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class RouteController implements RouteControllerInterface {

    @Autowired
    private RouteServiceInterface routeServiceInterface;

    @GetMapping("/routes")
    @ResponseStatus(HttpStatus.OK)
    public List<Route> getAllRoutes(){
        return routeServiceInterface.getAllRoutes();
    }

    @GetMapping("/routes/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Route getRouteById(Integer id){
        return routeServiceInterface.getRouteById(id);
    }

}