package com.capstone.planet.Model.DAO;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class TrashCanDAO {
    @Id
    Long trashCanId;
    Long userId;
    Double latitude;
    Double longitude;
    String imageUrl;
    String address;
}
