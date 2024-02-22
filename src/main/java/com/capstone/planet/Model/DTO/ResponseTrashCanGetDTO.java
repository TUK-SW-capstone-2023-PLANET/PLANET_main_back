package com.capstone.planet.Model.DTO;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ResponseTrashCanGetDTO {
    Long trashCanId;
    LocationDTO location;
    String imageUrl;
    String address;

    public static class ResponseTrashCanGetDTOBuilder {
        private Double latitude;
        private Double longitude;

        public ResponseTrashCanGetDTOBuilder location(Double latitude, Double longitude) {
            this.location = new LocationDTO(latitude, longitude);
            return this;
        }
    }
}
