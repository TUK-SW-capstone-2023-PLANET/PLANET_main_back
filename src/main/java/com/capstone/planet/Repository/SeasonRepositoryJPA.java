package com.capstone.planet.Repository;

import com.capstone.planet.Model.DAO.SeasonDAO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SeasonRepositoryJPA extends JpaRepository<SeasonDAO, Long>{

    SeasonDAO findByUserId(Long userId);

    Page<SeasonDAO> findAll(Pageable pageable);

    List<SeasonDAO> findAllByOrderByScoreDesc();

    List<SeasonDAO> findTop3ByOrderByScoreDesc();
}
