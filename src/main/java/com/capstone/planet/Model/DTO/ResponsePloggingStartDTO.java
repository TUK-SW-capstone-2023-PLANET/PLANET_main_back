package com.capstone.planet.Model.DTO;

import lombok.Data;

@Data
public class ResponsePloggingStartDTO {
    Long ploggingId;
    Long userId;
    Double weight;
    Double height;
}
