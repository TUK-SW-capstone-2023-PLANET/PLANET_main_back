package com.capstone.planet.Model.DTO;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ResponseTrashCanAllGetDTO {
    Long trashCanId;
    LocationDTO location;

    public static class ResponseTrashCanAllGetDTOBuilder {
        private Double latitude;
        private Double longitude;

        public ResponseTrashCanAllGetDTOBuilder location(Double latitude, Double longitude) {
            this.location = new LocationDTO(latitude, longitude);
            return this;
        }
    }
}
