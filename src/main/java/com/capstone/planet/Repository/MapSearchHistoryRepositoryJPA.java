package com.capstone.planet.Repository;

import com.capstone.planet.Model.DAO.MapSearchHistoryDAO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MapSearchHistoryRepositoryJPA extends JpaRepository<MapSearchHistoryDAO, Long>{
    List<MapSearchHistoryDAO> findByUserIdOrderByUploadTimeDesc(Long userId);
}
