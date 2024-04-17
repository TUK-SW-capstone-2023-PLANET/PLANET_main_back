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
    Long userId;
    String email;
    String passwd;
    String nickName;
    String message;
    String imageUrl;
    Double weight;
    Double height;
    String gender;
    String address;
    Integer ploggingCount;
    Integer trashCount;
    Double totalDistance;
    String universityName;
    String universityLogo;
    Integer score;
}
