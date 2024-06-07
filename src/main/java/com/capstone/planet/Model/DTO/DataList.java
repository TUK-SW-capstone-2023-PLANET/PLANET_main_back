package com.capstone.planet.Model.DTO;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class DataList {
    String day;
    Integer score;
}
