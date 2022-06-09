package com.ironhack.cyclobuddyserver.repository;

import com.ironhack.cyclobuddyserver.model.Ride;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RideRepository extends JpaRepository<Ride, Integer> {
}