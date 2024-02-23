package com.capstone.planet.Repository;

import com.capstone.planet.Model.DAO.PloggingDAO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PloggingRepositoryJPA extends JpaRepository<PloggingDAO, Long> {
}
