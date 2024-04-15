package com.capstone.planet.Model.DTO;

import lombok.Data;

@Data
public class RequestUserProfileSaveDTO {
    String email;
    String nickName;
    String password;
    String gender;
    Double weight;
    Double height;
}
