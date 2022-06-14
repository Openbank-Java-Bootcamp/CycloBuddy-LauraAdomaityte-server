package com.ironhack.cyclobuddyserver.service.interfaces;

import com.ironhack.cyclobuddyserver.DTO.RouteDTO;
import com.ironhack.cyclobuddyserver.model.Route;

import java.util.List;

public interface RouteServiceInterface {

    public List<Route> getAllRoutes();

    public Route getRouteById(Integer id);

    public void saveRoute(RouteDTO routeDTO);
}
