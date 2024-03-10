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
public class SeasonDAO {
    @Id
    Long seasonId;
    Long userId;
    String userName;
    String universityLogo;
    Integer score;
}
