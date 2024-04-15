package com.capstone.planet.Model.DTO;

import lombok.Data;

@Data
public class ResponseUserRanksGetDTO {
    private String nickName;
    private int score;
    private String universityLogo;
    Integer rank;
}
