package com.capstone.planet.Repository;

import com.capstone.planet.Model.DAO.PloggingLiveDAO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PloggingLiveRepositoryJPA extends JpaRepository<PloggingLiveDAO, Long> {
}
