package com.ironhack.cyclobuddyserver.controller.interfaces;

import com.ironhack.cyclobuddyserver.DTO.RouteDTO;
import com.ironhack.cyclobuddyserver.model.Route;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface RouteControllerInterface {
    public List<Route> getAllRoutes();

    public Route getRouteById(Integer id);

    public void saveTask(@RequestBody RouteDTO routeDTO);

}
