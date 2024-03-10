package com.capstone.planet.Repository;

import com.capstone.planet.Model.DAO.TierDAO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TierRepositoryJPA extends JpaRepository<TierDAO, Long> {

    List<TierDAO> findALLByOrderByTierIdAsc();
}
