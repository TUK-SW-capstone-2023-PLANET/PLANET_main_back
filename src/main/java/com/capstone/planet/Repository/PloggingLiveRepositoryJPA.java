package com.capstone.planet.Repository;

import com.capstone.planet.Model.DAO.PloggingLiveDAO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PloggingLiveRepositoryJPA extends JpaRepository<PloggingLiveDAO, Long> {

    List<PloggingLiveDAO> findByPloggingId(Long ploggingId);
    List<PloggingLiveDAO> findByPloggingIdOrderByUploadTimeAsc(Long ploggingId);
}
