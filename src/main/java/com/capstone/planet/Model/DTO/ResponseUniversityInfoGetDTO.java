package com.capstone.planet.Model.DTO;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ResponseUniversityInfoGetDTO {
    Long userId;
    String universityName;
    String universityLogo;
}
