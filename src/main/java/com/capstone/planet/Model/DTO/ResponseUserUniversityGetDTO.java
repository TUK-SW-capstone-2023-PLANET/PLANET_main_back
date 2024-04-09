package com.capstone.planet.Model.DTO;

import lombok.Data;

@Data
public class ResponseUserUniversityGetDTO {
    String nickName;
    Integer score;
    Integer rank;
    Double contribution;
}
