package com.capstone.planet.Model.DTO;

import lombok.Data;

@Data
public class ResponseSearchMapGetDTO {
    String text;
    boolean addressCheck;
    String date;
    LocationDTO location;
}
