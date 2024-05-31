package com.capstone.planet.Model.DTO;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ResponsePloggingGetsDTO {
    Long ploddingId;
    Long userId;
    String imageUrl;
    String address;
    Integer trashCount;
    String distance;
    String ploggingTime;
}
