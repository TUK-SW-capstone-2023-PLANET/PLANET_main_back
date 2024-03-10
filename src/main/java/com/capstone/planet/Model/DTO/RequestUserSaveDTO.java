package com.capstone.planet.Model.DTO;

import lombok.Data;

@Data
public class RequestUserSaveDTO {
    String loginId;
    String passwd;
    String nickName;
    String imageUrl;
    String address;
}
