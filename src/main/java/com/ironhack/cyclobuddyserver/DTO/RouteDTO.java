package com.ironhack.cyclobuddyserver.DTO;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RouteDTO {


    private Integer distance;
    private Integer elevationGain;
    private Integer estimatedRouteDuration;
    private String startPlace;
    private String endPlace;
    private String bicycleType;

}
