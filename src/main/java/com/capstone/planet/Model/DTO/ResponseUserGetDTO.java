package com.capstone.planet.Model.DTO;

import lombok.Data;

@Data
public class ResponseUserGetDTO {
    Long userId;
    String email;
    String passwd;
    String nickName;
    String message;
    String imageUrl;
    Double weight;
    Double height;
}
