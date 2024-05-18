package com.capstone.planet.Model.DTO;

import lombok.Builder;
import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
@Builder
public class ResponsePloggingGetDTO {
    Long ploggingId;
    String uploadTime;
    String runningTime;
    Integer ploggingTime;
    Integer trashCount;
    Double distance;
    Integer kcal;
    String pace;
    Integer score;
    List<LocationDTO> location;
    LocationDTO firstLocation;
    LocationDTO middleLocation;
    LocationDTO lastLocation;
    List<TrashDTO> trash;
    List<Map<String, List<TrashInfoDTO>>> trashInfo;
}
