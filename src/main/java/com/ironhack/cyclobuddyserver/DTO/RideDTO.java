package com.ironhack.cyclobuddyserver.DTO;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.ironhack.cyclobuddyserver.model.Ride;
import com.ironhack.cyclobuddyserver.model.Route;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.time.LocalTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RideDTO {

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd@HH:mm")
    private LocalDateTime rideDateAndTime;
    private String meetingLocation;
    private String closestCity;
    private String rideDescription;
    private Integer userId;
    private Route route;
}
