package com.capstone.planet.Model.DTO;

import lombok.Data;

@Data
public class ResponseSeasonUserGetDTO {
    String userName;
    Integer rank;
    String universityLogo;
    Integer score;
    String tierImageUrl;
    String tierName;
}
