package com.capstone.planet.Model.DTO;

import lombok.Data;

@Data
public class ResponseUserUniversityTop3GetDTO {
    String universityName;
    String universityLogo;
    String nickName;
    Integer score;
}
