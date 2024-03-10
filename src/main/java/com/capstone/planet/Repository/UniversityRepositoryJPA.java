package com.capstone.planet.Repository;

import com.capstone.planet.Model.DAO.UniversityDAO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UniversityRepositoryJPA extends JpaRepository<UniversityDAO, Long> {

    List<UniversityDAO> findTop3ByOrderByScoreDesc();
}
