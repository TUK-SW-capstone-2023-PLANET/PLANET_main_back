package com.capstone.planet.Model.DTO;

import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
public class RequestPloggingSaveDTO {
    Long ploggingId;
    Long userId;
    List<LocationDTO> location;
    List<Map<String, Integer>> trash;
    Double distance;
    Integer kcal;
    Double speed;
    Integer score;
    Integer ploggingTime;
}
