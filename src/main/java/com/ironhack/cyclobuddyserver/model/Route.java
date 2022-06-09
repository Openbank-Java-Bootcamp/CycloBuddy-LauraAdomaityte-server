package com.ironhack.cyclobuddyserver.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
    private String roadPicUrl;
    @Column(
            name = "route_id"
    )
    private Integer rideAssigned;
    @OneToOne(
            mappedBy = "route"
    )
    private Ride ride;
}
