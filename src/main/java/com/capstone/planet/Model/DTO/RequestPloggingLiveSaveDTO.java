package com.capstone.planet.Model.DTO;

import lombok.Data;

@Data
public class RequestPloggingLiveSaveDTO {
    Long userId;
    Long ploggingId;
    String imageUrl;
    Double latitude;
    Double longitude;
}
