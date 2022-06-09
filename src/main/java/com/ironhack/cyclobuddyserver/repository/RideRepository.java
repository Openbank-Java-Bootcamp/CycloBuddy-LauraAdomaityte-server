package com.ironhack.cyclobuddyserver.repository;

import com.ironhack.cyclobuddyserver.model.Ride;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RideRepository extends JpaRepository<Ride, Integer> {

    @Query(value = "SELECT * FROM ride WHERE user_id = :userId", nativeQuery = true)
    List<Ride> findRidesIdByUserId(Integer userId);
}