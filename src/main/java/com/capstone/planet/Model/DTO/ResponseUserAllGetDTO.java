package com.capstone.planet.Model.DTO;

import lombok.Data;

@Data
public class ResponseUserAllGetDTO {
    Integer userCount;
    Integer trashCount;
    Double distance;
}
