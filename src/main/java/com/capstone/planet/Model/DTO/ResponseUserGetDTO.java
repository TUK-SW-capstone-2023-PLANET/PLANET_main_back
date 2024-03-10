package com.capstone.planet.Model.DTO;

import lombok.Data;

@Data
public class ResponseUserGetDTO {
    Long userId;
    String loginId;
    String passwd;
    String nickName;
    String imageUrl;
    String address;
    Integer ploggingCount;
    Integer trashCount;
    Double totalDistance;
    Integer score;
}
