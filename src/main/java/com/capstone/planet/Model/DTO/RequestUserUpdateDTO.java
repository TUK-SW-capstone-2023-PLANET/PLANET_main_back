package com.capstone.planet.Model.DTO;

import lombok.Data;

@Data
public class RequestUserUpdateDTO {
    Long userId;
    String loginId;
    String passwd;
    String nickName;
    String imageUrl;
    String address;
}
