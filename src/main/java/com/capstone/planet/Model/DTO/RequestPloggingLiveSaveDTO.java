package com.capstone.planet.Model.DTO;

import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
public class RequestPloggingLiveSaveDTO {
    Long userId;
    Long ploggingId;
    String imageUrl;
    Double longitude;
    Double latitude;
    List<Map<String, Integer>> trash;
}
