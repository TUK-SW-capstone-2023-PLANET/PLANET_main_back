package com.capstone.planet.Model.DTO;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ResponseHotPostGetDTO {
    Long postId;
    String title;
    Integer heartCount;
}
