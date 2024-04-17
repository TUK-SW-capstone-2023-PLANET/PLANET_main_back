package com.capstone.planet.Model.DTO;

import lombok.Data;

@Data
public class RequestUserUpdateDTO {
    Long userId;
    String imageUrl;
    String nickName;
    String message;
    String passwd;
    Double weight;
    Double height;
}
