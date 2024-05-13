package com.capstone.planet.Model.DTO;

import lombok.Data;

import java.util.List;

@Data
public class RequestPostSaveDTO {
    Long userId;
    List<String> imageUrl;
    String title;
    String content;
}
