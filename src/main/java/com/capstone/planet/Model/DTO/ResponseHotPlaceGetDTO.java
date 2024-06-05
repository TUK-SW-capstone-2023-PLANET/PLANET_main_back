package com.capstone.planet.Model.DTO;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ResponseHotPlaceGetDTO {
    LocationDTO location;
    String address;
    Integer ploggingCount;
}
