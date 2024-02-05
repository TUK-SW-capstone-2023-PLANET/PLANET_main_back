package com.capstone.planet.Repository;

import com.capstone.planet.Model.DAO.UserDAO;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserRepositoryJPA extends JpaRepository<UserDAO, UUID> {
    UserDAO findByUserId(String userId);
}
