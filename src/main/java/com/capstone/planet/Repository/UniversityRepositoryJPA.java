package com.capstone.planet.Repository;

import com.capstone.planet.Model.DAO.UniversityDAO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UniversityRepositoryJPA extends JpaRepository<UniversityDAO, Long> {

    UniversityDAO findByName(String name);

    List<UniversityDAO> findTop3ByOrderByScoreDesc();

    List<UniversityDAO> findAllByOrderByScoreDesc();

    Page<UniversityDAO> findAll(Pageable pageable);
}
