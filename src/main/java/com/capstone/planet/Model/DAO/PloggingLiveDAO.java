package com.capstone.planet.Model.DAO;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class PloggingLiveDAO {
    @Id
    Long ploggingLiveId;
    Long userId;
    Long ploggingId;
    String imageUrl;
    Double latitude;
    Double longitude;
    String trash;
    String address;
    LocalDateTime uploadTime;
}
