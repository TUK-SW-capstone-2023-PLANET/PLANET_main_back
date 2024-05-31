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
public class PloggingDAO {
    @Id
    Long ploggingId;
    Long userId;
    String imageUrl;
    String location;
    String trash;
    Integer trashCount;
    Double distance;
    Integer kcal;
    String pace;
    Integer score;
    Integer ploggingTime;
    String month;
    Integer day;
    String address;
    LocalDateTime uploadTime;
}
