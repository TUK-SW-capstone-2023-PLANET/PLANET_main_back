package com.capstone.planet.Model.DTO;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TrashDTO {
    String name;
    Integer count;
    Integer score;
}
