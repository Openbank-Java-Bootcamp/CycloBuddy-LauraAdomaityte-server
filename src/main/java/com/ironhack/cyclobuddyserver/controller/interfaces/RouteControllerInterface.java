package com.ironhack.cyclobuddyserver.controller.interfaces;

import com.ironhack.cyclobuddyserver.model.Route;

import java.util.List;

public interface RouteControllerInterface {
    public List<Route> getAllRoutes();

    public Route getRouteById(Integer id);

}
