package com.ironhack.cyclobuddyserver.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Route {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private Integer id;
    private Integer distance;
    private Integer elevationGain;
    private Integer estimatedRouteDuration;
    private String startPlace;
    private String endPlace;
    private String bicycleType;
    @Column(
            name = "route_id"
    )
    private Integer rideAssigned;

   /* public Route(Integer distance, Integer elevationGain, Integer estimatedRouteDuration, String startPlace, String endPlace, String bicycleType, Integer rideAssigned) {
        this.distance = distance;
        this.elevationGain = elevationGain;
        this.estimatedRouteDuration = estimatedRouteDuration;
        this.startPlace = startPlace;
        this.endPlace = endPlace;
        this.bicycleType = bicycleType;
        this.rideAssigned = rideAssigned;
    }*/


    public Route(Integer distance, Integer elevationGain, Integer estimatedRouteDuration, String startPlace, String endPlace, String bicycleType) {
        this.distance = distance;
        this.elevationGain = elevationGain;
        this.estimatedRouteDuration = estimatedRouteDuration;
        this.startPlace = startPlace;
        this.endPlace = endPlace;
        this.bicycleType = bicycleType;
    }


}
