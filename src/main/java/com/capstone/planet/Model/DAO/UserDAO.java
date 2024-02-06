package com.capstone.planet.Model.DAO;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UserDAO {
    @Id
    Long userHandleId;
    String userId;
    String passwd;
    String nickName;
    String imageUrl;
    String address;
    Integer ploggingCount;
    Integer trashCount;
    Double totalDistance;
    Integer score;
}
