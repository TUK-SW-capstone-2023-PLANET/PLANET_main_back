package com.capstone.planet.Model.DTO;

import lombok.Data;

@Data
public class RequestUserSaveDTO {
    String userId;
    String passwd;
    String nickName;
    String imageUrl;
    String address;
}
