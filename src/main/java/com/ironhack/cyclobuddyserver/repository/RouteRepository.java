package com.ironhack.cyclobuddyserver.repository;

import com.ironhack.cyclobuddyserver.model.Route;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RouteRepository extends JpaRepository<Route, Integer> {
}
