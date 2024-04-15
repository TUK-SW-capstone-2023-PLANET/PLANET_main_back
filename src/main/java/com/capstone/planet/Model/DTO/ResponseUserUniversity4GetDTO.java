package com.capstone.planet.Model.DTO;

import lombok.Data;

@Data
public class ResponseUserUniversity4GetDTO {
    String nickName;
    Integer score;
    Integer rank;
    Double contribution;
    String universityName;
    String universityLogo;
    String imageUrl;
}
