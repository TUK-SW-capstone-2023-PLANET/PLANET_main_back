package com.capstone.planet.Model.DTO;

import lombok.Data;

@Data
public class ResponseUserGetDTO {
    Long userId;
    String email;
    String passwd;
    String nickName;
    String imageUrl;
    Double weight;
    Double height;
    String gender;
    String address;
    Integer ploggingCount;
    Integer trashCount;
    Double totalDistance;
    String universityName;
    String universityLogo;
    Integer score;
}
