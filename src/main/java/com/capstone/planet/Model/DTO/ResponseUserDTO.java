package com.capstone.planet.Model.DTO;

import lombok.Data;

@Data
public class ResponseUserDTO {
    Long userHandleId;
    String userId;
    String passwd;
    String nickName;
    String imageUrl;
    String address;
    Integer ploggingCount;
    Integer trashCount;
    Double totalDistance;
    Integer score;
}
