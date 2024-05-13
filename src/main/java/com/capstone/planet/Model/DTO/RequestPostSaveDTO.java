package com.capstone.planet.Model.DTO;

import lombok.Data;

@Data
public class RequestPostSaveDTO {
    Long userId;
    String imageUrl;
    String title;
    String content;
}
