package com.capstone.planet.Model.DTO;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TrashInfoDTO {
    String name;
    String imageUrl;
    String address;
    Integer count;
    Integer score;
    Integer totalScore;
}
