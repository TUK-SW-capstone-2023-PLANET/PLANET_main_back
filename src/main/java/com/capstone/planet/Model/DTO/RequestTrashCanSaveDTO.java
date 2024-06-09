package com.capstone.planet.Model.DTO;

import lombok.Data;

@Data
public class RequestTrashCanSaveDTO {
    Long userId;
    Double latitude;
    Double longitude;
    String imageUrl;
}
