package com.capstone.planet.Repository;

import com.capstone.planet.Model.DAO.UserDAO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepositoryJPA extends JpaRepository<UserDAO, Long> {
    UserDAO findByUserId(String userId);

    @Query("SELECT COUNT(u) FROM UserDAO u")
    Integer getTotalUserCount();

    @Query("SELECT SUM(u.trashCount) FROM UserDAO u")
    Integer getTotalTrashCount();

    @Query("SELECT SUM(u.totalDistance) FROM UserDAO u")
    Double getTotalDistanceSum();
}
