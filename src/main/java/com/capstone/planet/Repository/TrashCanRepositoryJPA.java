package com.capstone.planet.Repository;

import com.capstone.planet.Model.DAO.TrashCanDAO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TrashCanRepositoryJPA extends JpaRepository<TrashCanDAO, Long> {
}
